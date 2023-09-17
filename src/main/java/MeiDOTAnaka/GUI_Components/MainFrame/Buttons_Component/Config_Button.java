package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.Config.Config_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Config_Button extends JButton implements ActionListener, MeiDOTAnaka_Button {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    Selected_Panel selectedPanel;
    State_Panel state_panel;

    public Config_Button() {
        setFocusable(false);
        setText("Config");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            SwingUtilities.invokeLater(() -> {
                System.out.println("Config Button Was cliked");
                meiDOTAnakaFrame.setTitle("Yay workin");
                selectedPanel.updateSelectionText("Configuration");

                selectedPanel.validate();
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

    @Override
    public void setContext(MeiDOTAnakaFrrame_m context_frame, Selected_Panel context_panel, State_Panel state_panel) {
        this.meiDOTAnakaFrame = context_frame;
        this.selectedPanel    = context_panel;
        this.state_panel      = state_panel;
    }
}
