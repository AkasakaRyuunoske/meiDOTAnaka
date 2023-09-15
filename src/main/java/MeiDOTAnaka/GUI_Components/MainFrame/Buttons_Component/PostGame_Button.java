package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostGame_Button  extends JButton implements ActionListener {
    public PostGame_Button(){
        setFocusable(false);

        setText("Post Game");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            System.out.println("Post Game Button Was cliked");
        }
    }
}
