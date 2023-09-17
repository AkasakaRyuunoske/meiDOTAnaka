package MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component;

import javax.swing.*;
import java.awt.*;

public class Selected_Panel extends JPanel {
    public Selected_Label selectedLabel;

    public Selected_Panel() {
        selectedLabel = new Selected_Label();
        setBackground(Color.magenta);

        add(selectedLabel);
    }

    public void updateSelectionText(String newSelectionText){
        selectedLabel.setText(newSelectionText);
    }
}
