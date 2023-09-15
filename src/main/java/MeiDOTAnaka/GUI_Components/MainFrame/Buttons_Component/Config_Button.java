package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Config_Button extends JButton implements ActionListener {
    public Config_Button() {
        setFocusable(false);
        setText("Config");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.out.println("Config Button Was cliked");
        }
    }
}
