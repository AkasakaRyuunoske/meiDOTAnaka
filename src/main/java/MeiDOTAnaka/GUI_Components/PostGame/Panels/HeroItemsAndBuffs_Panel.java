package MeiDOTAnaka.GUI_Components.PostGame.Panels;

import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroInventory.HeroInventory_Panel;
import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroInventory.HeroItemBuffs_Panel;
import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroInventory.HeroSkillBuffs_Panel;

import javax.swing.*;
import java.awt.*;

public class HeroItemsAndBuffs_Panel extends JLabel {
    public HeroSkillBuffs_Panel heroSkillBuffs_panel;
    public HeroItemBuffs_Panel heroItemBuffs_panel;
    public HeroInventory_Panel heroInventory_panel;

    public HeroItemsAndBuffs_Panel(){
        setLayout(new GridLayout(1,3));

        heroInventory_panel = new HeroInventory_Panel();
        heroItemBuffs_panel = new HeroItemBuffs_Panel();
        heroSkillBuffs_panel = new HeroSkillBuffs_Panel();

        add(heroSkillBuffs_panel);
        add(heroInventory_panel);
        add(heroItemBuffs_panel);
    }
}
