package MeiDOTAnaka.GUI_Components.PostGame;

import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroImportantStats.HeroImportantStats_Panel;
import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroInventory.HeroInventory_Panel;
import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroItemsAndBuffs_Panel;
import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroKillsStats_Panel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class PostGame_Panel extends JPanel {
    public HeroImportantStats_Panel heroImportantStats_panel;
    public HeroItemsAndBuffs_Panel heroItemsAndBuffs_panel;
    public HeroKillsStats_Panel heroKillsStats_panel;

    public PostGame_Panel(){
        setBackground(Color.RED);
        setLayout(new GridLayout(3,1));

        heroImportantStats_panel = new HeroImportantStats_Panel();
        heroItemsAndBuffs_panel = new HeroItemsAndBuffs_Panel();
        heroKillsStats_panel = new HeroKillsStats_Panel();

        add(heroItemsAndBuffs_panel);
        add(heroImportantStats_panel);
        add(heroKillsStats_panel);
    }
}
