package MeiDOTAnaka.GUI_Components.CurrentGame.Panels;

import MeiDOTAnaka.GUI_Components.CurrentGame.Labels.PlayerInfo_Labels.*;

import javax.swing.*;
import java.awt.*;

public class PlayerInfo_Panel  extends JPanel {
    APM_Label apm_label;
    GPM_Label gpm_label;
    XPM_Label xpm_label;
    Networth_Label networth_label;
    PlayerInfo_Label playerInfo_label;

    public PlayerInfo_Panel(){
        setBackground(new Color(17,17,17));

        setLayout(new GridLayout(2,2));

        apm_label = new APM_Label();
        gpm_label = new GPM_Label();
        xpm_label = new XPM_Label();
        networth_label = new Networth_Label();
        playerInfo_label = new PlayerInfo_Label();

        add(apm_label);
        add(gpm_label);
        add(xpm_label);
        add(networth_label);
        add(playerInfo_label);

    }
}
