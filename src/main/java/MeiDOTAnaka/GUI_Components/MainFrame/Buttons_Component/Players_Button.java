package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Players_Button extends JButton implements ActionListener {
    public Players_Button() {
        setFocusable(false);
        setText("Players");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.out.println("Players Button Was cliked");
        }
    }
}
