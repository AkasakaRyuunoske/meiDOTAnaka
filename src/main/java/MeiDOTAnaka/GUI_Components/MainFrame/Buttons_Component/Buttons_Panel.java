package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import javax.swing.*;
import java.awt.*;

public class Buttons_Panel extends JPanel {
    Config_Button config_button;
    CurrentGame_Button currentGame_button;
    Graphs_Button graphs_button;
    Players_Button players_button;
    PostGame_Button postGame_button;

    public Buttons_Panel(){
        setLayout(new GridLayout(10, 1));

        config_button = new Config_Button();
        currentGame_button = new CurrentGame_Button();
        graphs_button = new Graphs_Button();
        players_button = new Players_Button();
        postGame_button = new PostGame_Button();

        add(config_button);
        add(currentGame_button);
        add(graphs_button);
        add(players_button);
        add(postGame_button);

        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel("Ping: ")); //#todo implement ping module here
    }
}
