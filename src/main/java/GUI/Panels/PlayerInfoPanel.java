package GUI.Panels;

import GUI.Labels.PlayerInfo.*;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoPanel extends JPanel {
    APM_Label apm_label;
    GPM_Label gpm_label;
    Networth_Label networth_label;
    PlayerInfoTitle_Label playerInfoTitle_label;
    XPM_Label xpmLabel;

    public PlayerInfoPanel(){
        setBackground(Color.GRAY);
        setLayout(new GridLayout(10, 1));

        apm_label = new APM_Label();
        gpm_label = new GPM_Label();
        networth_label = new Networth_Label();
        playerInfoTitle_label = new PlayerInfoTitle_Label();
        xpmLabel = new XPM_Label();

        add(apm_label);
        add(gpm_label);
        add(networth_label);
        add(playerInfoTitle_label);
        add(xpmLabel);
    }

    public void updateData(String apm, String gpm, String xpm, String networth){
        apm_label.setText     ("Current APM: "      + apm     );
        gpm_label.setText     ("Current GPM: "      + gpm     );
        xpmLabel.setText      ("Current XPM: "      + xpm     );
        networth_label.setText("Current Networth: " + networth);
    }
}
