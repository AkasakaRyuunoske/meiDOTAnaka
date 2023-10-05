package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component.UserInfo_Component;

import MeiDOTAnaka.Services.Configuration.ConfigurationManager;
import org.checkerframework.checker.units.qual.C;

import javax.swing.*;
import java.awt.*;

public class UserInfo_Panel extends JPanel {
    JLabel ping_label;
    JLabel steamid_label;
    JLabel dota_username_label;
    JLabel dota_account_id;

    ConfigurationManager configurationManager;

    public UserInfo_Panel(){
        setLayout(new GridLayout(4,1));

        ping_label = new JLabel();
        steamid_label = new JLabel();
        dota_username_label = new JLabel();
        dota_account_id = new JLabel();

        configurationManager = new ConfigurationManager();

        ping_label.setText("Ping: ");
        steamid_label.setText("Steam id: 1770131945");
        dota_account_id.setText("dota id: " + configurationManager.getValueFromConfigurationFile("labels", 2, "text"));
        dota_username_label.setText("User: " + configurationManager.getValueFromConfigurationFile("labels", 1, "text"));

        add(ping_label);
        add(steamid_label);
        add(dota_account_id);
        add(dota_username_label);
    }
}
