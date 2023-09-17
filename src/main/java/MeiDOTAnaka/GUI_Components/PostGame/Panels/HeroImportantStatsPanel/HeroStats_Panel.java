package MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroImportantStatsPanel;

import MeiDOTAnaka.GUI_Components.PostGame.Labels.HeroImportantStatsLabels.*;

import javax.swing.*;
import java.awt.*;

public class HeroStats_Panel extends JPanel {
    APM_Stat_Label apm_stat_label;
    DPM_Stat_Label dpm_stat_label;
    GPM_Stat_Label gpm_stat_label;
    XPM_Stat_Label xpm_stat_label;
    KDA_Stat_Label kda_stat_label;
    Creeps_Stat_Label creeps_stat_label;
    Networth_Stat_Label networth_stat_label;

    public HeroStats_Panel(){
        setLayout(new GridLayout(10, 1));
        setBackground(Color.ORANGE);

        apm_stat_label = new APM_Stat_Label();
        dpm_stat_label = new DPM_Stat_Label();
        gpm_stat_label = new GPM_Stat_Label();
        xpm_stat_label = new XPM_Stat_Label();
        kda_stat_label = new KDA_Stat_Label();
        creeps_stat_label = new Creeps_Stat_Label();
        networth_stat_label = new Networth_Stat_Label();

        add(apm_stat_label);
        add(dpm_stat_label);
        add(gpm_stat_label);
        add(xpm_stat_label);
        add(kda_stat_label);
        add(creeps_stat_label);
        add(networth_stat_label);
    }
}
