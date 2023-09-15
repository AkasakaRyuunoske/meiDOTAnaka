package MeiDOTAnaka.GUI_Components.CurrentGame;

import MeiDOTAnaka.GUI_Components.CurrentGame.Panels.DraftInfo_Panel;
import MeiDOTAnaka.GUI_Components.CurrentGame.Panels.HeroInfo_Panel;
import MeiDOTAnaka.GUI_Components.CurrentGame.Panels.PlayerInfo_Panel;
import MeiDOTAnaka.GUI_Components.CurrentGame.Panels.RadiantDraftInfo_Panel;
import MeiDOTAnaka.GUI_Components.Players.Players_Panel;

import javax.swing.*;
import java.awt.*;

public class CurrentGame_Panel extends JPanel {
    DraftInfo_Panel draftInfo_panel;
    RadiantDraftInfo_Panel radiantDraftInfo_panel;
    PlayerInfo_Panel players_panel;
    HeroInfo_Panel heroInfo_panel;

    GridBagConstraints gridBagConstraints;

    public CurrentGame_Panel(){
        gridBagConstraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        setBackground(Color.GRAY);

        draftInfo_panel = new DraftInfo_Panel();
        radiantDraftInfo_panel = new RadiantDraftInfo_Panel();
        players_panel = new PlayerInfo_Panel();
        heroInfo_panel = new HeroInfo_Panel();

        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 1;

        add(draftInfo_panel, gridBagConstraints);

        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 1;

        add(radiantDraftInfo_panel, gridBagConstraints);

        gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 2;

        add(players_panel, gridBagConstraints);

        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 2;

        add(heroInfo_panel, gridBagConstraints);
    }
}
