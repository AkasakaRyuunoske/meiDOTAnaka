package MeiDOTAnaka.GUI_Components.Config;

import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.Services.Configuration.ConfigurationManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportConfigFile_Button extends JButton implements ActionListener {
    private ConfigurationManager configurationManager;
    public MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    public ImportConfigFile_Button(){
        configurationManager = new ConfigurationManager();

        setText("Import Config File");
        setName("import_config_file_button");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            configurationManager.getConfigurationFile();
            configurationManager.readConfigurationFile();

            configurationManager.applyConfiguration(this);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().currentGame_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().postGame_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().cringeList_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().graphs_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().players_button);
        }
    }
}
