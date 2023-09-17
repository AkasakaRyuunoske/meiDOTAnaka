package MeiDOTAnaka.GUI_Components.CurrentGame.Panels;

import javax.swing.*;
import java.awt.*;

public class DraftInfo_Panel extends JPanel {
    public DraftInfo_Panel(){
        setLayout(new GridLayout(11, 1));

//        setBackground(Color.BLUE);

        add(new JLabel("Hero #1"));
        add(new JLabel("Hero #2"));
        add(new JLabel("Hero #3"));
        add(new JLabel("Hero #4"));
        add(new JLabel("Hero #5"));
    }
}
