package MeiDOTAnaka.GUI_Components.Config;

import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;

import javax.swing.*;
import java.awt.*;

public class Config_Panel extends JPanel {
    private ImportConfigFile_Button getConfigFileButton;
    public Config_Panel(){
        getConfigFileButton = new ImportConfigFile_Button();
        add(getConfigFileButton);
        setBackground(new Color(17,17,17));
    }

    public void setContextFrame(MeiDOTAnakaFrrame_m contextFrame){
        getConfigFileButton.meiDOTAnakaFrame = contextFrame;
    }
}
