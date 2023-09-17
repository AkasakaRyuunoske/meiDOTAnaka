package MeiDOTAnaka.GUI_Components.PostGame.Panels;

import MeiDOTAnaka.GUI_Components.PostGame.Labels.HeroInventoryItem_Label;

import javax.swing.*;
import java.awt.*;

public class HeroInventory_Panel extends JPanel {
    HeroInventoryItem_Label item_slot_1;
    HeroInventoryItem_Label item_slot_2;
    HeroInventoryItem_Label item_slot_3;
    HeroInventoryItem_Label item_slot_4;
    HeroInventoryItem_Label item_slot_5;
    HeroInventoryItem_Label item_slot_6;
    HeroInventoryItem_Label item_slot_7;
    HeroInventoryItem_Label item_slot_8;
    public HeroInventory_Panel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(2,4));

        item_slot_1 = new HeroInventoryItem_Label();
        item_slot_2 = new HeroInventoryItem_Label();
        item_slot_3 = new HeroInventoryItem_Label();
        item_slot_4 = new HeroInventoryItem_Label();
        item_slot_5 = new HeroInventoryItem_Label();
        item_slot_6 = new HeroInventoryItem_Label();
        item_slot_7 = new HeroInventoryItem_Label();
        item_slot_8 = new HeroInventoryItem_Label();

        add(item_slot_1);
        add(item_slot_2);
        add(item_slot_3);
        add(item_slot_4);
        add(item_slot_5);
        add(item_slot_6);
        add(item_slot_7);
        add(item_slot_8);
    }
}
