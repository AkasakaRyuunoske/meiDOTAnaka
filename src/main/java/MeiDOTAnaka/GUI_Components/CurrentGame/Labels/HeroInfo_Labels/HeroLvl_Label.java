package GUI.Labels.HeroInfo;

import javax.swing.*;

public class HeroLvl_Label extends JLabel {
    public HeroLvl_Label(){
        setText("Lvl 1");
    }

    public void updateHeroLvl(int newLvl){
        setText(String.valueOf(newLvl));
    }
}
