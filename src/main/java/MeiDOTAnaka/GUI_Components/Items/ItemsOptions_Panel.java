package MeiDOTAnaka.GUI_Components.Items;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemsOptions_Panel extends JPanel implements ActionListener {
    private JPanel filteringOptions_Panel;
    private JButton filterByMobility_filteringOptionButton;
    private JButton filterByAttackSpeed_filteringOptionButton;
    private JButton filterByDamage_filteringOptionButton;
    private JButton filterByControl_filteringOptionButton;
    private JComboBox<String> viewOptions_ComboBox;

    public ItemsOptions_Panel(){
        setLayout(new GridLayout(1,2));

        filteringOptions_Panel = new JPanel();
        filteringOptions_Panel.setLayout(new GridLayout(1,5));

        filterByMobility_filteringOptionButton    = new JButton("filterByMobility_filteringOptionButton");
        filterByAttackSpeed_filteringOptionButton = new JButton("filterByAttackSpeed_filteringOptionButton");
        filterByDamage_filteringOptionButton      = new JButton("filterByDamage_filteringOptionButton");
        filterByControl_filteringOptionButton     = new JButton("filterByControl_filteringOptionButton");

        filterByMobility_filteringOptionButton.addActionListener(this::actionPerformed);
        filterByAttackSpeed_filteringOptionButton.addActionListener(this::actionPerformed);
        filterByDamage_filteringOptionButton.addActionListener(this::actionPerformed);
        filterByControl_filteringOptionButton.addActionListener(this::actionPerformed);

        filterByMobility_filteringOptionButton.setFocusable(false);
        filterByAttackSpeed_filteringOptionButton.setFocusable(false);
        filterByDamage_filteringOptionButton.setFocusable(false);
        filterByControl_filteringOptionButton.setFocusable(false);

        filteringOptions_Panel.add(filterByMobility_filteringOptionButton);
        filteringOptions_Panel.add(filterByAttackSpeed_filteringOptionButton);
        filteringOptions_Panel.add(filterByDamage_filteringOptionButton);
        filteringOptions_Panel.add(filterByControl_filteringOptionButton);

        viewOptions_ComboBox = new JComboBox<>();
        viewOptions_ComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"option 1", "option 2", "option 3","option 4"}));

        viewOptions_ComboBox.addActionListener(this::actionPerformed);

        add(filteringOptions_Panel);
        add(viewOptions_ComboBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == filterByMobility_filteringOptionButton){
            System.out.println("filterByMobility_filteringOptionButton");
        }

        if (e.getSource() == filterByAttackSpeed_filteringOptionButton){
            System.out.println("filterByAttackSpeed_filteringOptionButton");
        }

        if (e.getSource() == filterByDamage_filteringOptionButton){
            System.out.println("filterByDamage_filteringOptionButton");
        }

        if (e.getSource() == filterByControl_filteringOptionButton){
            System.out.println("filterByControl_filteringOptionButton");
        }

        if (e.getSource() == viewOptions_ComboBox){
            System.out.println("viewOptions_ComboBox");
        }
    }
}
