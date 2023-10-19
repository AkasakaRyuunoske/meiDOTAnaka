package MeiDOTAnaka.GUI_Components.CurrentGame.Labels.PlayerInfo_Labels;

import MeiDOTAnaka.GUI_Components.CurrentGame.Labels.DynamicLabel;

import javax.swing.*;
import java.awt.*;

public class APM_Label extends JLabel implements DynamicLabel {
    String text = "Current APM: ";

    public APM_Label(){
        setForeground(Color.magenta);
        setText(text);
    }

    @Override
    public void updateText(String newText) {
        setText(text + newText);
    }
}
