package MeiDOTAnaka.GUI_Components.Config.FileActionButtons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFile_Button extends JButton implements ActionListener {
    public NewFile_Button(){
        setText("New");

        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.out.println("New yet to be implemented");
        }
    }
}
