package MeiDOTAnaka.GUI_Components.Config.FileActionButtons;

import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.Services.Configuration.ConfigurationManager;
import MeiDOTAnaka.GUI_Components.Config.ConfigEditor_TextArea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyFile_Button extends JButton implements ActionListener {
    private ConfigEditor_TextArea configEditor_textArea;
    private ConfigurationManager configurationManager;

    private MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    public ApplyFile_Button(ConfigEditor_TextArea configEditor_textArea, MeiDOTAnakaFrrame_m meiDOTAnakaFrame){
        this.meiDOTAnakaFrame = meiDOTAnakaFrame;
        this.configEditor_textArea = configEditor_textArea;
        configurationManager = new ConfigurationManager();

        setText("Apply Configuration");

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            configurationManager.readAndParseConfigurationFile();

            configurationManager.applyConfiguration(this);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().currentGame_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().postGame_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().cringeList_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().graphs_button);
            configurationManager.applyConfiguration(meiDOTAnakaFrame.getButtons_panel().items_button);

            System.out.println("Apply yet to be implemented");
        }
    }
}
