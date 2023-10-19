package MeiDOTAnaka.GUI_Components.CurrentGame.Labels.HeroInfo_Labels;

import MeiDOTAnaka.GUI_Components.CurrentGame.Labels.DynamicLabel;

import javax.swing.*;
import java.awt.*;

public class HeroLvl_Label extends JLabel implements DynamicLabel {
    String text = "Lvl: ";

    public HeroLvl_Label(){
        setForeground(Color.magenta);
    }

    @Override
    public void updateText(String newText) {
        setText(text + newText);
    }
}
