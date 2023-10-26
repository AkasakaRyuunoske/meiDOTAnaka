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
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(new GridBagLayout());

        // initialization
        heroInventory_panel  = new HeroInventory_Panel();
        heroItemBuffs_panel  = new HeroItemBuffs_Panel();
        heroSkillBuffs_panel = new HeroSkillBuffs_Panel();


        // heroSkillBuffs_panel
        gridBagConstraints.fill    = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 1.0;

        add(heroSkillBuffs_panel, gridBagConstraints);


        // heroInventory_panel
        gridBagConstraints.fill    = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;

        add(heroInventory_panel, gridBagConstraints);


        // heroItemBuffs_panel
        gridBagConstraints.fill    = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 1.0;

        add(heroItemBuffs_panel, gridBagConstraints);
    }
}
