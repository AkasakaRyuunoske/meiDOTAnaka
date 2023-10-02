package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component.UserInfo_Component.UserInfo_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;

import javax.swing.*;
import java.awt.*;

public class Buttons_Panel extends JPanel {
    Config_Button config_button;
    CurrentGame_Button currentGame_button;
    Graphs_Button graphs_button;
    Players_Button players_button;
    PostGame_Button postGame_button;
    CringeList_Button cringeList_button;
    UserInfo_Panel userInfo_panel;

    public Buttons_Panel(){
        setBackground(Color.black);
        setLayout(new GridLayout(10, 1));

        config_button = new Config_Button();
        currentGame_button = new CurrentGame_Button();
        graphs_button = new Graphs_Button();
        players_button = new Players_Button();
        postGame_button = new PostGame_Button();
        cringeList_button = new CringeList_Button();
        userInfo_panel = new UserInfo_Panel();

        add(config_button);
        add(currentGame_button);
        add(graphs_button);
        add(players_button);
        add(postGame_button);
        add(cringeList_button);

        // placeholders for if I decide to put more elements here. For now they just separate buttons from user info
//        add(new JLabel());

        JLabel yellow_part = new JLabel();
        JLabel blue_part = new JLabel();

        yellow_part.setBackground(Color.yellow);
        yellow_part.setOpaque(true);

        blue_part.setBackground(Color.blue);
        blue_part.setOpaque(true);

        add(blue_part);
        add(yellow_part);

        add(new JLabel());

        add(userInfo_panel);
    }

    public void setButtonsContext(MeiDOTAnakaFrrame_m context_frame, Selected_Panel context_panel, State_Panel state_panel) {
        config_button.setContext     (context_frame, context_panel, state_panel);
        currentGame_button.setContext(context_frame, context_panel, state_panel);
        graphs_button.setContext     (context_frame, context_panel, state_panel);
        players_button.setContext    (context_frame, context_panel, state_panel);
        postGame_button.setContext   (context_frame, context_panel, state_panel);
    }
}
