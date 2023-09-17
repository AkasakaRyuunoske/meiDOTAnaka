package MeiDOTAnaka.GUI_Components.PostGame;

import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroImportantStatsPanel.HeroImportantStats_Panel;
import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroInventory_Panel;
import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroKillsStats_Panel;

import javax.swing.*;
import java.awt.*;

public class PostGame_Panel extends JPanel {
    HeroImportantStats_Panel heroImportantStats_panel;
    HeroInventory_Panel heroInventory_panel;
    HeroKillsStats_Panel heroKillsStats_panel;

    public PostGame_Panel(){
        setBackground(Color.RED);
        setLayout(new GridLayout(3,1));

        heroImportantStats_panel = new HeroImportantStats_Panel();
        heroInventory_panel = new HeroInventory_Panel();
        heroKillsStats_panel = new HeroKillsStats_Panel();

        add(heroInventory_panel);
        add(heroImportantStats_panel);
        add(heroKillsStats_panel);
    }
}
