package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;
import MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570.GetMatchDetails;
import MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570.MatchDetailsParser;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PostGame_Button  extends JButton implements ActionListener, MeiDOTAnaka_Button {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    Selected_Panel selectedPanel;
    State_Panel state_panel;
    GetMatchDetails getMatchDetails = new GetMatchDetails();

    public PostGame_Button(){
        setBackground(null);
        setFocusable(false);

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
            System.out.println("Post Game Button Was cliked");

            selectedPanel.selectedLabel.setText("Post Game");
            selectedPanel.setBackground(Color.GRAY);

            state_panel.remove(state_panel.current_panel);
            state_panel.add(state_panel.postGame_panel, state_panel.gridBagConstraints);
            state_panel.current_panel = state_panel.postGame_panel;

            meiDOTAnakaFrame.revalidate();
            meiDOTAnakaFrame.repaint();

            System.out.println("Current Selection label text: " + selectedPanel.selectedLabel.getText());
            System.out.println("Current state: " + state_panel.current_panel.toString());

            connect();
        });
    }

    public void connect(){
        try {
            if (state_panel.current_panel == state_panel.postGame_panel){
                System.out.println("Oki connecting");

                MatchDetailsParser matchDetailsParser = new MatchDetailsParser();
                JsonObject match = getMatchDetails.getFullMatchDetailsById("7340504781");
                matchDetailsParser.getPlayersFromJsonObject(match);
                System.out.println("hero id: " + matchDetailsParser.getPlayersFromJsonObject(match).get(1).getAsJsonObject().get("hero_id"));

                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.gpm_stat_label.setText("GPM: " + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("gold_per_min").toString());
                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.xpm_stat_label.setText("XPM: " + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("xp_per_min").toString());

                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.kda_stat_label
                        .setText("KDA: "
                                + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("kills").toString()
                                + "/"
                                + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("deaths").toString()
                                + "/"
                                + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("assists").toString()
                        );

                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.dpm_stat_label.setText("DPM: " + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("hero_damage").toString());
                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.networth_stat_label.setText("Networth: " + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("net_worth").toString());
                state_panel.postGame_panel.heroImportantStats_panel.heroStats_panel.creeps_stat_label
                        .setText("Creeps: "
                                + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("last_hits").toString()
                                + "/"
                                + matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("denies").toString()
                        );

                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_1.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("item_0").toString());
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_2.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("item_1").toString());
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_3.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("item_2").toString());
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_4.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("item_3").toString());
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_5.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("item_4").toString());
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroActiveSlots_panel.item_slot_6.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("item_5").toString());

                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroBackpack_panel.backpack_item_1.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("backpack_0").toString());
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroBackpack_panel.backpack_item_2.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("backpack_1").toString());
                state_panel.postGame_panel.heroItemsAndBuffs_panel.heroInventory_panel.heroBackpack_panel.backpack_item_3.setText(matchDetailsParser.getPlayersFromJsonObject(match).get(0).getAsJsonObject().get("backpack_2").toString());

            } else {
                System.err.println("Something went wrong. Probably swing took too much to switch panels");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
