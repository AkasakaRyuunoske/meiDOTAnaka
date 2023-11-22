package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.Services.OOPing.OOPingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OOPingButton extends JButton implements ActionListener {
    public OOPingButton(){
        setText("OOPING STARTER");

        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            OOPingApp ooPing = new OOPingApp();

            ooPing.setVisible(true);
        }
    }
}
