package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component.UserInfo_Component;

import javax.swing.*;
import java.awt.*;

public class UserInfo_Panel extends JPanel {
    JLabel ping_label;
    JLabel steamid_label;
    JLabel dota_username_label;

    public UserInfo_Panel(){
        setLayout(new GridLayout(3,1));

        ping_label = new JLabel();
        steamid_label = new JLabel();
        dota_username_label = new JLabel();

        ping_label.setText("Ping: ");
        steamid_label.setText("Steam id: 1770131945");
        dota_username_label.setText("User: mode: demon eater");

        add(ping_label);
        add(steamid_label);
        add(dota_username_label);
    }
}
