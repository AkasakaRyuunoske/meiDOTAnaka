package MeiDOTAnaka.GUI_Components.MainFrame;

import MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component.Buttons_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;

import javax.swing.*;
import java.awt.*;

public class MeiDOTAnakaFrrame_m extends JFrame {
    Selected_Panel selected_panel;
    State_Panel state_panel;
    Buttons_Panel buttons_panel;
    public MeiDOTAnakaFrrame_m(){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setTitle("MeiDOTAnata - Your cringe assistant written by cringe ukrainian refugee");

        selected_panel = new Selected_Panel();
        state_panel = new State_Panel();
        buttons_panel = new Buttons_Panel();

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1; // Panel takes 10% of the screen width
        gridBagConstraints.weighty = 1.0; // Both panels take full vertical space

        add(buttons_panel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;

        add(state_panel, gridBagConstraints);

        setVisible(true);
    }
}
