package MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component;

import javax.swing.*;
import java.awt.*;

public class Selected_Panel  extends JPanel {
    Selected_Label selectedLabel;

    public Selected_Panel(){
        selectedLabel = new Selected_Label();
        setBackground(Color.magenta);

        add(selectedLabel);
    }
}
