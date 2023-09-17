package MeiDOTAnaka.GUI_Components.CurrentGame.Labels.HeroInfo_Labels;

import javax.swing.*;
import javax.swing.plaf.ProgressBarUI;
import java.awt.*;

public class HeroHP_ProgressBar extends JPanel {
    JProgressBar heroHP_Bar;

    int currentHP;
    int maxHP;

    public HeroHP_ProgressBar(){
        heroHP_Bar = new JProgressBar();
        heroHP_Bar.setMaximum(604);
        heroHP_Bar.setMinimum(0);
        heroHP_Bar.setValue(0);
        heroHP_Bar.setStringPainted(true);

        heroHP_Bar.setBackground(Color.RED);

        heroHP_Bar.setString("604/604");
//        heroHP_Bar.setOpaque(true);

        add(heroHP_Bar);
    }

    public void updateHeroCurrentHP(int newHp){
        currentHP = newHp;

        heroHP_Bar.setValue(newHp);
        heroHP_Bar.setString(currentHP + "/" + maxHP);
        System.out.println("heroHP_Bar.getValue(): " + heroHP_Bar.getValue());
    }

    public void updateHeroMaxHP(int newMaxHp){
        maxHP = newMaxHp;

        SwingUtilities.invokeLater(()->heroHP_Bar.setMaximum(newMaxHp));
//        heroHP_Bar.setMaximum(newMaxHp);
        System.out.println("heroHP_Bar.setMaximum(): " + heroHP_Bar.getMaximum());
    }
}
