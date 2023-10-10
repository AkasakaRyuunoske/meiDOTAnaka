package MeiDOTAnaka.GUI_Components.Indicators;

import MeiDOTAnaka.MeiDOTAnakaApp;

import javax.swing.*;
import java.awt.*;

public class DownloadProgressBar extends JProgressBar {
    public JFrame frame;
    public JLabel logLabel;

    public DownloadProgressBar(int min, int max){
        setMinimum(min);
        setMaximum(max);
        setString("Download progress...");
        setStringPainted(true);
        setOpaque(true);

        logLabel = new JLabel("####################################################################################################");

        frame = new JFrame("Progress...");
        frame.setLayout(new GridLayout(2,1));

        frame.add(this);
        frame.add(logLabel);

        frame.setLocationRelativeTo(MeiDOTAnakaApp.meiDOTAnakaFrrame_m.getState_panel().current_panel);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

//        frame.setEnabled(false);

        frame.pack();
        frame.setVisible(true);
    }
}
