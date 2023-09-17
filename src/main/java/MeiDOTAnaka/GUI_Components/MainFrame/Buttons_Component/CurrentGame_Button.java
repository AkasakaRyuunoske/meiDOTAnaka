package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentGame_Button  extends JButton implements ActionListener, MeiDOTAnaka_Button {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    Selected_Panel selectedPanel;
    State_Panel state_panel;

    public CurrentGame_Button(){
        setFocusable(false);
        setText("Current Game");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            System.out.println("Current Game Button Was cliked");

            selectedPanel.selectedLabel.setText("Current Game");

            state_panel.remove(state_panel.current_panel);
            state_panel.add(state_panel.currentGame_panel, state_panel.gridBagConstraints);
            state_panel.current_panel = state_panel.currentGame_panel;

            meiDOTAnakaFrame.revalidate();
            System.out.println("Current Selection label text: " + selectedPanel.selectedLabel.getText());
        }
    }

    @Override
    public void setContext(MeiDOTAnakaFrrame_m context_frame, Selected_Panel context_panel, State_Panel state_panel) {
        this.meiDOTAnakaFrame = context_frame;
        this.selectedPanel    = context_panel;
        this.state_panel      = state_panel;
    }
}
