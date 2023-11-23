package MeiDOTAnaka.GUI_Components.Config.FileActionButtons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyFile_Button extends JButton implements ActionListener {
    public ApplyFile_Button(){
        setText("Apply Configuration");

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.out.println("Apply yet to be implemented");
        }
    }
}
