package GUI.Panels;

import GUI.Labels.HeroInfo.*;

import javax.swing.*;
import java.awt.*;

public class HeroPanel extends JPanel {
    HeroMP_ProgressBar heroMP_progressBar;
    HeroHP_ProgressBar heroHP_progressBar;

    HeroLvl_Label heroLvlLabel;
    HeroName_Label heroName_label;
    HeroAghanimScepter_Label heroAghanimScepterLabel;
    HeroAghanimShard_Label heroAghanimShardLabel;
    public HeroPanel(){
        setBackground(Color.magenta);
        setLayout(new GridLayout(3,1));

        heroHP_progressBar = new HeroHP_ProgressBar();
        heroMP_progressBar = new HeroMP_ProgressBar();

        heroLvlLabel = new HeroLvl_Label();
        heroName_label = new HeroName_Label();
        heroAghanimShardLabel = new HeroAghanimShard_Label();
        heroAghanimScepterLabel = new HeroAghanimScepter_Label();

        add(heroLvlLabel);
        add(heroName_label);
        add(heroAghanimScepterLabel);
        add(heroAghanimShardLabel);

        add(heroHP_progressBar);
        add(heroMP_progressBar);
    }

    public void updateLables(){

    }

    public void updateHeroCurrentHP(int newCurrentHP){
        heroHP_progressBar.updateHeroCurrentHP(newCurrentHP);
        System.out.println("Hero current hp is: " + newCurrentHP);
    }

    public void updateHeroMaxHP(int newMaxHP){
        heroHP_progressBar.updateHeroMaxHP(newMaxHP);
        System.out.println("Hero max hp is: " + newMaxHP);
    }

    public void updateHeroMaxMP(int newMaxMP){
        heroMP_progressBar.updateHeroMaxMP(newMaxMP);
    }

    public void updateHeroCurrentMP(int newCurrentMP){
        heroMP_progressBar.updateHeroCurrentMP(newCurrentMP);
    }

    public void updateHeroLvl(int newLvl){
        heroLvlLabel.updateHeroLvl(newLvl);
    }
}
