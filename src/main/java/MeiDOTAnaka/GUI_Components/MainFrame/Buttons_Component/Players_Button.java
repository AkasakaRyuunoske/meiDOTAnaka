package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Players_Button extends JButton implements ActionListener, MeiDOTAnaka_Button {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    Selected_Panel selectedPanel;
    State_Panel state_panel;

    public Players_Button() {
        setFocusable(false);
        setText("Players");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
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
            System.out.println("Players Button Was cliked");

            selectedPanel.selectedLabel.setText("Players");

            state_panel.remove(state_panel.current_panel);
            state_panel.add(state_panel.players_panel, state_panel.gridBagConstraints);
            state_panel.current_panel = state_panel.players_panel;

            meiDOTAnakaFrame.revalidate();
            meiDOTAnakaFrame.repaint();
            System.out.println("Current Selection label text: " + selectedPanel.selectedLabel.getText());
            System.out.println("Current state: " + state_panel.current_panel.toString());
        });
    }
}
