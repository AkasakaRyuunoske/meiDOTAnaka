package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;
import MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570.GetMatchDetails;
import MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570.MatchDetailsParser;
import MeiDOTAnaka.Services.Dota2RestAPIs.IEconDOTA2_570.HeroesService;
import MeiDOTAnaka.Services.Dota2RestAPIs.IEconDOTA2_570.ItemsService;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class PostGame_Button  extends JButton implements ActionListener, MeiDOTAnaka_Button {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    Selected_Panel selectedPanel;
    State_Panel state_panel;
    ItemsService itemsService;
    GetMatchDetails getMatchDetails = new GetMatchDetails();

    public PostGame_Button(){
        setBackground(null);
        setFocusable(false);
        setName("post_game_button");

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src\\main\\java\\MeiDOTAnaka\\Resources\\Fonts\\OldEnglishTextMT.ttf"));
            Font sizedFont = font.deriveFont(Font.BOLD, 28f);
            setFont(sizedFont);
            setForeground(new Color(111, 24, 211));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        setText("Post Game");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            switchPanel();
            state_panel.selected_panel.selectedLabel.setText("Post Game");
        }
    }

    @Override
    public void setContext(@NotNull MeiDOTAnakaFrrame_m context_frame, @NotNull Selected_Panel context_panel, @NotNull State_Panel state_panel) {
        this.meiDOTAnakaFrame = context_frame;
        this.selectedPanel    = context_panel;
        this.state_panel      = state_panel;
    }

    @Override
    public void switchPanel() {
        // seems like using invoke later is more thread safe, but idk.
        SwingUtilities.invokeLater(() -> {
            selectedPanel.selectedLabel.setText("Post Game");
            state_panel.remove(state_panel.current_panel);
            state_panel.add(state_panel.postGame_panel, state_panel.gridBagConstraints);
            state_panel.current_panel = state_panel.postGame_panel;

            meiDOTAnakaFrame.revalidate();
            meiDOTAnakaFrame.repaint();

            connect();
        });
    }

    public void connect(){
        try {
            if (state_panel.current_panel == state_panel.postGame_panel){
                System.out.println("Oki connecting");

                MatchDetailsParser matchDetailsParser = new MatchDetailsParser();
                JsonObject match = getMatchDetails.getFullMatchDetailsById();
                matchDetailsParser.getPlayersFromJsonObject(match);
                System.out.println("hero id: " + matchDetailsParser.getPlayersFromJsonObject(match).get(1).getAsJsonObject().get("hero_id"));

                JsonObject you_as_player;

                int i = 0;
                while (true){
                    if (matchDetailsParser.getPlayersFromJsonObject(match).get(i).getAsJsonObject().get("account_id").toString().equals("441084075")){
                        System.out.println("found!");
                        you_as_player = matchDetailsParser.getPlayersFromJsonObject(match).get(i).getAsJsonObject();
                        break;
                    } else {
                        i++;
                    }
                }


                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.gpm_stat_label.setText("GPM: " + you_as_player.get("gold_per_min").toString());
                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.xpm_stat_label.setText("XPM: " + you_as_player.get("xp_per_min").toString());

                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.kda_stat_label
                        .setText("KDA: "
                                + you_as_player.get("kills").toString()
                                + "/"
                                + you_as_player.get("deaths").toString()
                                + "/"
                                + you_as_player.get("assists").toString()
                        );

                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.dpm_stat_label.setText("DPM: " + you_as_player.get("hero_damage").toString());
                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.networth_stat_label.setText("Networth: " + you_as_player.get("net_worth").toString());
                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.creeps_stat_label
                        .setText("Creeps: "
                                + you_as_player.get("last_hits").toString()
                                + "/"
                                + you_as_player.get("denies").toString()
                        );

                //############################## Icons ################################

                // contains items with which player finished the game
                Stack<String> usedItems = new Stack<>();
                for (int j = 0; j < 6; j++) {
                    usedItems.push(you_as_player.get("item_" + j).toString());
                }
                usedItems.push(you_as_player.get("backpack_0").toString());
                usedItems.push(you_as_player.get("backpack_1").toString());
                usedItems.push(you_as_player.get("backpack_2").toString());

                usedItems.push(you_as_player.get("item_neutral").toString());

                itemsService = new ItemsService();
                JsonObject usedItemIds = itemsService.getAllItemIds();

                Stack<String> usedItemNames = new Stack<>();
                for (int j = 0; j < 10; j++) {
                    // 0 is defined as empty slot by vulvo
                    if (usedItems.peek().equals("0")){
                        usedItems.pop();
                        continue;
                    }

                    usedItemNames.push(usedItemIds.get(usedItems.pop()).toString());
                }

                JsonObject itemsIcons = itemsService.getAllItems();

                System.out.println("usedItemNames: " + usedItemNames);
//                for (int j = 0; j < usedItemNames.size(); j++) {
//                    // 0 is defined as empty slot by vulvo
////                    if (usedItems.peek().equals("0")){
////                        usedItems.pop();
////                        continue;
////                    }
//                    System.out.println(usedItems.push(itemsIcons.get(usedItemNames.pop().replaceAll("\"","")).getAsJsonObject().get("img").toString()));
//                }

                try {
                    while (usedItems.push(itemsIcons.get(usedItemNames.pop().replaceAll("\"","")).getAsJsonObject().get("img").toString()) != null);

                } catch (EmptyStackException emptyStackException) {
                    System.out.println("okay, finished staking");
                }

                System.out.println("item icons: " + usedItems);

                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_1.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_2.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_3.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_4.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_5.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_6.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));

                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroBackpack_panel.backpack_item_1.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroBackpack_panel.backpack_item_2.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));
//                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroBackpack_panel.backpack_item_3.setText(usedItems.pop()); #todo don't forget

                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_7_neutral.setIcon(itemsService.getItemImageByUrl(usedItems.pop()));
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_7_neutral.setText("");

                System.out.println("you_as_player: " + you_as_player);

                //#todo remove this dialog AFTER YOU RESOLVED THE WRONG ORDER ISSUE
                JOptionPane.showConfirmDialog(null, "Remember that they are in WRONG ORDER (basically random order)", "AHTUNG", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);


                //############################## Hero Image ################################
                HeroesService heroesService = new HeroesService();
                JsonObject allHeroes = heroesService.getAllHeroes();
                JsonObject playedHero = allHeroes.getAsJsonObject(you_as_player.get("hero_id").getAsString());

                state_panel.postGame_panel.heroImportantStats_panel.hero_panel.getHero_image().setIcon(heroesService.getHeroIconByUrl(playedHero.get("img").getAsString()));
            } else {
                System.err.println("Something went wrong. Probably swing took too much to switch panels");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
