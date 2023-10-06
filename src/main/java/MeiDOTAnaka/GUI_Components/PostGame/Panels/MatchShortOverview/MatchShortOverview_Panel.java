package MeiDOTAnaka.GUI_Components.PostGame.Panels.MatchShortOverview;

import MeiDOTAnaka.GUI_Components.Items.ItemsOptions_Panel;

import javax.swing.*;
import java.awt.*;

public class MatchShortOverview_Panel extends JPanel {
    ItemsOptions_Panel shortOverviewOptionsPanel;

    public MatchShortOverview_Panel(){
        setLayout(new GridLayout(2,1));
        setBackground(Color.lightGray);

        shortOverviewOptionsPanel = new ItemsOptions_Panel();

        add(shortOverviewOptionsPanel);
    }
}
