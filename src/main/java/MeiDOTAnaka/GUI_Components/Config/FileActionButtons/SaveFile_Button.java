package MeiDOTAnaka.GUI_Components.Config.FileActionButtons;

import MeiDOTAnaka.GUI_Components.Config.ConfigEditor_TextArea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFile_Button extends JButton implements ActionListener {
    private ConfigEditor_TextArea configEditor_textArea;
    public SaveFile_Button(ConfigEditor_TextArea configEditor_textArea){
        this.configEditor_textArea = configEditor_textArea;
        setText("Save");

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.out.println(configEditor_textArea.getText() + " configEditor_textArea.getText()");
            System.out.println(configEditor_textArea.getSelectedText() + " configEditor_textArea.getSelectedText()");
            System.out.println("Save yet to be implemented");
        }
    }
}
