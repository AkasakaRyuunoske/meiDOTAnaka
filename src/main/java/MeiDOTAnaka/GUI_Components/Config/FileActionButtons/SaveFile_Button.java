package MeiDOTAnaka.GUI_Components.Config.FileActionButtons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFile_Button extends JButton implements ActionListener {
    public SaveFile_Button(){
        setText("Save");

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.out.println("Save yet to be implemented");
        }
    }
}
