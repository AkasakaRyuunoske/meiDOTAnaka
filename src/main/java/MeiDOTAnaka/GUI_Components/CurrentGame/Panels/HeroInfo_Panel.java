package MeiDOTAnaka.GUI_Components.CurrentGame.Panels;

import MeiDOTAnaka.GUI_Components.CurrentGame.Labels.HeroInfo_Labels.*;

import javax.swing.*;
import java.awt.*;

public class HeroInfo_Panel extends JPanel {
    HeroInfo_Label heroInfo_label;
    HeroAghanimScepter_Label heroAghanimScepter_label;
    HeroAghanimShard_Label heroAghanimShard_label;

    HeroHP_ProgressBar heroHP_progressBar;
    HeroMP_ProgressBar heroMP_progressBar;
    HeroLvl_Label heroLvl_label;
    HeroName_Label heroName_label;

    public HeroInfo_Panel(){
        heroAghanimScepter_label = new HeroAghanimScepter_Label();
        heroAghanimShard_label = new HeroAghanimShard_Label();
        heroHP_progressBar = new HeroHP_ProgressBar();
        heroMP_progressBar = new HeroMP_ProgressBar();
        heroLvl_label = new HeroLvl_Label();
        heroName_label = new HeroName_Label();
        heroInfo_label = new HeroInfo_Label();

//        setBackground(Color.GREEN);
        add(heroInfo_label);
        add(heroAghanimScepter_label);
        add(heroAghanimShard_label);
        add(heroHP_progressBar);
        add(heroMP_progressBar);
        add(heroLvl_label);
        add(heroName_label);
    }
}
