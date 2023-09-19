package MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroInventory;

import javax.swing.*;
import java.awt.*;

public class HeroInventory_Panel extends JPanel {
    public HeroActiveSlots_Panel heroActiveSlots_panel;
    public HeroBackpack_Panel heroBackpack_panel;

    public HeroInventory_Panel(){
        setLayout(new GridLayout(2, 1));
        setBackground(Color.PINK);

        heroActiveSlots_panel = new HeroActiveSlots_Panel();
        heroBackpack_panel = new HeroBackpack_Panel();

        add(heroActiveSlots_panel);
        add(heroBackpack_panel);
    }
}
