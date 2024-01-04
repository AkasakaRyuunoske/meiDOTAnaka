package MeiDOTAnaka.GUI_Components.MainFrame.MainPanel;

import MeiDOTAnaka.GUI_Components.Config.Config_Panel;
import MeiDOTAnaka.GUI_Components.CringeList.Panels.CringeList_Panel;
import MeiDOTAnaka.GUI_Components.CurrentGame.CurrentGame_Panel;
import MeiDOTAnaka.GUI_Components.Graphs.Graphs_Panel;
import MeiDOTAnaka.GUI_Components.Items.Items_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;
import MeiDOTAnaka.GUI_Components.Players.Players_Panel;
import MeiDOTAnaka.GUI_Components.PostGame.PostGame_Panel;

import javax.swing.*;
import java.awt.*;

public class State_Panel extends JPanel {
    public Config_Panel config_panel;
    public PostGame_Panel postGame_panel;
    public Players_Panel players_panel;
    public Graphs_Panel graphs_panel;
    public CurrentGame_Panel currentGame_panel;

    public Selected_Panel selected_panel;
    public Items_Panel items_panel;
    public JPanel current_panel;

    public GridBagConstraints gridBagConstraints;
    public CringeList_Panel cringeList_panel;

    private MeiDOTAnakaFrrame_m meiDOTAnakaFrrame_m;

    public State_Panel(MeiDOTAnakaFrrame_m meiDOTAnakaFrrame_m){
        this.meiDOTAnakaFrrame_m = meiDOTAnakaFrrame_m;

        gridBagConstraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        selected_panel = new Selected_Panel();

        config_panel = new Config_Panel(meiDOTAnakaFrrame_m);
        postGame_panel = new PostGame_Panel();
        players_panel = new Players_Panel();
        graphs_panel = new Graphs_Panel();
        currentGame_panel = new CurrentGame_Panel();
        items_panel = new Items_Panel();
        cringeList_panel = new CringeList_Panel();


        gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.0;
        gridBagConstraints.gridy = 1;

        add(selected_panel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridy = 2;

        add(postGame_panel, gridBagConstraints);
        current_panel = postGame_panel;
    }
}
