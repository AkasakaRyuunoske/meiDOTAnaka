package MeiDOTAnaka.GUI_Components.Config.FileActionButtons;

import MeiDOTAnaka.GUI_Components.Config.ConfigEditor_TextArea;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.Services.Configuration.ConfigurationManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportFile_Button extends JButton implements ActionListener {
    private ConfigurationManager configurationManager;
    private MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    private ConfigEditor_TextArea configEditorTextArea;
    public ImportFile_Button(ConfigEditor_TextArea configEditorTextArea, MeiDOTAnakaFrrame_m meiDOTAnakaFrame){
        this.meiDOTAnakaFrame = meiDOTAnakaFrame;
        this.configEditorTextArea = configEditorTextArea;
        configurationManager = new ConfigurationManager();

        setText("Import Config File");
        setName("import_config_file_button");

        addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            configurationManager.chooseConfigurationFile();
            configurationManager.readAndParseConfigurationFile();

            configurationManager.applyConfiguration(this);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().currentGame_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().postGame_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().cringeList_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().graphs_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().items_button);

            configEditorTextArea.setText(configurationManager.readFile(configurationManager.getConfigurationFile()));
        }
    }
}
