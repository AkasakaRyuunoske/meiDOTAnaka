package GUI.Labels.HeroInfo;

import javax.swing.*;
import java.awt.*;

public class HeroMP_ProgressBar extends JPanel {
    JProgressBar heroMP_Bar;

    int currentMP;
    int maxMP;

    public HeroMP_ProgressBar(){
        heroMP_Bar = new JProgressBar();
        heroMP_Bar.setMaximum(363);
        heroMP_Bar.setMinimum(1);
        heroMP_Bar.setValue(363);
        heroMP_Bar.setStringPainted(true);

        heroMP_Bar.setBackground(Color.BLUE);

        add(heroMP_Bar);
    }

    public void updateHeroCurrentMP(int newMp){
        currentMP = newMp;

        heroMP_Bar.setValue(newMp);
        heroMP_Bar.setString(currentMP + "/" + maxMP);
        System.out.println("heroHP_Bar.getValue(): " + heroMP_Bar.getValue());
    }

    public void updateHeroMaxMP(int newMaxMp){
        maxMP = newMaxMp;

        SwingUtilities.invokeLater(()->heroMP_Bar.setMaximum(newMaxMp));
        System.out.println("heroMP_Bar.getMaximum(): " + heroMP_Bar.getMaximum());
    }
}
