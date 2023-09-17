package MeiDOTAnaka.GUI_Components.CurrentGame.Panels;

import javax.swing.*;
import java.awt.*;

public class RadiantDraftInfo_Panel extends JPanel {
    public RadiantDraftInfo_Panel(){
        setLayout(new GridLayout(11, 1));

//        setBackground(Color.CYAN);

        add(new JLabel("Dire 10 / Radiant 22"));
        add(new JLabel("Hero #1"));
        add(new JLabel("Hero #2"));
        add(new JLabel("Hero #3"));
        add(new JLabel("Hero #4"));
        add(new JLabel("Hero #5"));
    }
}
