package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphs_Button  extends JButton implements ActionListener {
    public Graphs_Button(){
        setFocusable(false);
        setText("Graphs");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            System.out.println("Graphs Button Was cliked");
        }
    }
}
