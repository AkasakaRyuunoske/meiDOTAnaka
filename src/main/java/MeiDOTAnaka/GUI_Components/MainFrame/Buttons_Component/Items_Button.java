package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component.MeiDOTAnaka_Button;
import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Items_Button extends JButton implements ActionListener, MeiDOTAnaka_Button {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    Selected_Panel selectedPanel;
    State_Panel state_panel;

    public Items_Button() {
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
            state_panel.selected_panel.selectedLabel.setText("Items");
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
            selectedPanel.selectedLabel.setText("Items");

            state_panel.remove(state_panel.current_panel);
            state_panel.add(state_panel.items_panel, state_panel.gridBagConstraints);
            state_panel.current_panel = state_panel.items_panel;

            meiDOTAnakaFrame.revalidate();
            meiDOTAnakaFrame.repaint();
        });
    }
}
