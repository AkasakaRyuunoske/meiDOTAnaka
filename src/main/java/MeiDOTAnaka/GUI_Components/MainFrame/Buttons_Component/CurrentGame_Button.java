package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentGame_Button  extends JButton implements ActionListener {
    public CurrentGame_Button(){
        setFocusable(false);
        setText("Current Game");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            System.out.println("Current Game Button Was cliked");
        }
    }
}
