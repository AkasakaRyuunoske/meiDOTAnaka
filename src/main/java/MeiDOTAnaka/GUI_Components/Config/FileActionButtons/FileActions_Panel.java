package MeiDOTAnaka.GUI_Components.Config.FileActionButtons;

import MeiDOTAnaka.GUI_Components.Config.ConfigEditor_TextArea;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;

import javax.swing.*;
import java.awt.*;

public class FileActions_Panel extends JPanel {
    ApplyFile_Button applyFile_button;
    NewFile_Button newFile_button;
    SaveFile_Button saveFile_button;
    ImportFile_Button importFile_button;

    private MeiDOTAnakaFrrame_m meiDOTAnakaFrame;

    public FileActions_Panel(ConfigEditor_TextArea configEditor_textArea, MeiDOTAnakaFrrame_m meiDOTAnakaFrame){
        this.meiDOTAnakaFrame = meiDOTAnakaFrame;
        System.out.println("here it's not null: " + meiDOTAnakaFrame);

        setLayout(new GridLayout(1, 5));
        setBackground(Color.CYAN);

        applyFile_button = new ApplyFile_Button(configEditor_textArea, meiDOTAnakaFrame);
        newFile_button = new NewFile_Button();
        saveFile_button = new SaveFile_Button(configEditor_textArea);
        importFile_button = new ImportFile_Button(configEditor_textArea, meiDOTAnakaFrame);

        add(applyFile_button);
        add(newFile_button);
        add(saveFile_button);
        add(importFile_button);
        add(new JLabel("test.cringe"));
    }
}
