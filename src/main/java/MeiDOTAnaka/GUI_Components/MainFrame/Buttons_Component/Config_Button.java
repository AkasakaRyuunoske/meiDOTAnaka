package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.Config.Config_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;
import MeiDOTAnaka.Services.Configuration.ConfigurationManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Config_Button extends JButton implements ActionListener, MeiDOTAnaka_Button {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    Selected_Panel selectedPanel;
    State_Panel state_panel;
    ConfigurationManager configurationManager;

    public Config_Button() {
        configurationManager = new ConfigurationManager();

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

        setText("Config");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            switchPanel();
//            configurationManager.getConfigurationFile();
//            configurationManager.readConfigurationFile();
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
            selectedPanel.selectedLabel.setText("New selection");

            System.out.println("Config Button Was cliked");

            meiDOTAnakaFrame.setTitle("Yay workin");
            selectedPanel.updateSelectionText("Configuration");

            state_panel.selected_panel.selectedLabel.setText("Configuration");

            selectedPanel.revalidate();
            selectedPanel.repaint();

            state_panel.remove(state_panel.current_panel);
            state_panel.add(state_panel.config_panel, state_panel.gridBagConstraints);
            state_panel.current_panel = state_panel.config_panel;

            meiDOTAnakaFrame.revalidate();
            meiDOTAnakaFrame.repaint();
            System.out.println("Current Selection label text: " + selectedPanel.selectedLabel.getText());
            System.out.println("Current state: " + state_panel.current_panel.toString());
            System.out.println("Current selection panel background: " + selectedPanel.getBackground());
        });
    }
}
