package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;
import MeiDOTAnaka.Services.Dota2RestAPIs.IEconDOTA2_570.ItemsService;
import com.google.gson.JsonObject;
import netscape.javascript.JSObject;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Items_Button extends JButton implements ActionListener, MeiDOTAnaka_Button {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    Selected_Panel selectedPanel;
    State_Panel state_panel;

    private ItemsService itemsService;

    public Items_Button() {
        itemsService = new ItemsService();

        setBackground(null);
        setFocusable(false);
        setText("Items");
        setName("items_button");

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src\\main\\java\\MeiDOTAnaka\\Resources\\Fonts\\OldEnglishTextMT.ttf"));
            Font sizedFont = font.deriveFont(Font.BOLD, 28f);
            setFont(sizedFont);
            setForeground(new Color(111, 24, 211));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            switchPanel();
            connect();
        }
    }

    @Override
    public void setContext(@NotNull MeiDOTAnakaFrrame_m context_frame, @NotNull Selected_Panel context_panel, @NotNull State_Panel state_panel) {
        this.meiDOTAnakaFrame = context_frame;
        this.selectedPanel = context_panel;
        this.state_panel = state_panel;
    }

    @Override
    public void switchPanel() {
        // seems like using invoke later is more thread safe, but idk.
        SwingUtilities.invokeLater(() -> {
            state_panel.selected_panel.selectedLabel.setText("Items");

            state_panel.remove(state_panel.current_panel);
            state_panel.add(state_panel.items_panel, state_panel.gridBagConstraints);
            state_panel.current_panel = state_panel.items_panel;

            meiDOTAnakaFrame.revalidate();
            meiDOTAnakaFrame.repaint();
        });
    }

    private void connect() {
        Thread thread = new Thread(() -> {
            JsonObject allItemsJSON = itemsService.getAllItems();

            Iterator<String> iterator = allItemsJSON.keySet().iterator();

            try {
                int i = 0;
                Image image;
                URL url;

                JFrame frame = new JFrame("Progress...");
                JProgressBar downloadProgressBar = new JProgressBar(0, 50);
                downloadProgressBar.setString("Download progress...");
                downloadProgressBar.setStringPainted(true);
                downloadProgressBar.setOpaque(true);

                frame.add(downloadProgressBar);
                frame.setLocationRelativeTo(meiDOTAnakaFrame.getState_panel().current_panel);
                frame.setResizable(false);
                frame.setAlwaysOnTop(true);
                frame.pack();
                frame.setVisible(true);

                Random random = new Random();

                JsonObject item;
                String itemJson;
                while (iterator.hasNext() && i < 50) {
                    itemJson = iterator.next();
                    item = allItemsJSON.getAsJsonObject(itemJson);

                    downloadProgressBar.setValue(i);
                    downloadProgressBar.setString("Download progress... %" + i);
                    downloadProgressBar.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    downloadProgressBar.setForeground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

                    System.out.println("Download of item images in progress... %" + i);

                    i++;
                    url = new URL("https://api.opendota.com" + item.get("img").toString().replaceAll("\"", ""));
                    image = ImageIO.read(url);

//                    itemJson = itemJson.replaceAll("_", " ");

                    itemJson = itemJson.replaceFirst(String.valueOf(itemJson.charAt(0)), String.valueOf(itemJson.charAt(0)).toUpperCase());

                    int count = itemJson.length() - itemJson.replace("_", "").length();

                    for (int j = 0; j < count; j++) {
                        itemJson = itemJson.replace(
                                String.valueOf(itemJson.charAt(itemJson.indexOf("_"))) + String.valueOf(itemJson.charAt(itemJson.indexOf("_") + 1)),
                                " " + String.valueOf(itemJson.charAt(itemJson.indexOf("_") + 1)).toUpperCase()
                        );
                    }

                    state_panel.items_panel.defaultTableModel.addRow(new Object[]{
                            itemJson,
                            item.get("cost").toString(),
                            new ImageIcon(image)
                    });
                }

                frame.setVisible(false);

            } catch (IOException ioException) {
                System.out.println("shit happends: " + ioException.getMessage());
            }
        });

        thread.start();
    }
}
