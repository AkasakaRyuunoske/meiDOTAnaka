package MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroInventory;

import MeiDOTAnaka.GUI_Components.PostGame.Labels.HeroInventoryItem_Label;

import javax.swing.*;
import java.awt.*;

public class HeroBackpack_Panel extends JPanel {
    public HeroInventoryItem_Label backpack_item_1;
    public HeroInventoryItem_Label backpack_item_2;
    public HeroInventoryItem_Label backpack_item_3;
    public HeroBackpack_Panel(){
        setLayout(new GridLayout(1,3));

        backpack_item_1 = new HeroInventoryItem_Label();
        backpack_item_2 = new HeroInventoryItem_Label();
        backpack_item_3 = new HeroInventoryItem_Label();

        add(backpack_item_1);
        add(backpack_item_2);
        add(backpack_item_3);
    }
}
