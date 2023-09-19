package MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroInventory;

import MeiDOTAnaka.GUI_Components.PostGame.Labels.HeroInventoryItem_Label;

import javax.swing.*;
import java.awt.*;

public class HeroActiveSlots_Panel extends JPanel {
    public HeroInventoryItem_Label item_slot_1;
    public HeroInventoryItem_Label item_slot_2;
    public HeroInventoryItem_Label item_slot_3;
    public HeroInventoryItem_Label item_slot_4;
    public HeroInventoryItem_Label item_slot_5;
    public HeroInventoryItem_Label item_slot_6;
    public HeroInventoryItem_Label item_slot_7_neutral;
    public HeroInventoryItem_Label item_slot_8_teleport;
    public HeroActiveSlots_Panel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(2,4));

        item_slot_1 = new HeroInventoryItem_Label();
        item_slot_2 = new HeroInventoryItem_Label();
        item_slot_3 = new HeroInventoryItem_Label();
        item_slot_4 = new HeroInventoryItem_Label();
        item_slot_5 = new HeroInventoryItem_Label();
        item_slot_6 = new HeroInventoryItem_Label();
        item_slot_7_neutral = new HeroInventoryItem_Label();
        item_slot_8_teleport = new HeroInventoryItem_Label();

        item_slot_7_neutral.setText("I am neutral item slot yay");
        item_slot_8_teleport.setText("And I am teleport");

        add(item_slot_1);
        add(item_slot_2);
        add(item_slot_3);
        add(item_slot_7_neutral);
        add(item_slot_4);
        add(item_slot_5);
        add(item_slot_6);
        add(item_slot_8_teleport);
    }
}
