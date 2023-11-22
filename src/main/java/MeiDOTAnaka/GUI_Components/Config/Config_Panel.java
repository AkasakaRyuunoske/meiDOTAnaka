package MeiDOTAnaka.GUI_Components.Config;

import MeiDOTAnaka.GUI_Components.Config.FileActionButtons.FileActions_Panel;
import MeiDOTAnaka.GUI_Components.Config.FileActionButtons.ImportFile_Button;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;

import javax.swing.*;
import java.awt.*;

public class Config_Panel extends JPanel {
    private FileActions_Panel fileActionsPanel;
    private ConfigEditor_TextArea configEditorTextArea;
    private MeiDOTAnakaFrrame_m meiDOTAnakaFrame;
    public Config_Panel(MeiDOTAnakaFrrame_m meiDOTAnakaFrrame_m){
        this.meiDOTAnakaFrame = meiDOTAnakaFrrame_m;

        setLayout(new GridLayout(2,1));

        configEditorTextArea = new ConfigEditor_TextArea();
        fileActionsPanel = new FileActions_Panel(configEditorTextArea, meiDOTAnakaFrame);

        JScrollPane configEditorTextArea_Scroll = new JScrollPane(configEditorTextArea);

        add(fileActionsPanel);
        add(configEditorTextArea_Scroll);

        setBackground(new Color(17,17,17));
    }

    public void setContextFrame(MeiDOTAnakaFrrame_m contextFrame){
        this.meiDOTAnakaFrame = contextFrame;
    }
}
