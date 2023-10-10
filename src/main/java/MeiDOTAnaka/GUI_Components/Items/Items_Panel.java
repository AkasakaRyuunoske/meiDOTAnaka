package MeiDOTAnaka.GUI_Components.Items;

import MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroItemsAndBuffs_Panel;
import MeiDOTAnaka.MeiDOTAnakaApp;
import org.checkerframework.checker.units.qual.C;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Items_Panel extends JPanel {
    ItemsOptions_Panel itemsOptionsPanel;
    public JTable items_table;
    public DefaultTableModel defaultTableModel;
    private String[] columns = {"name", "cost", "icon"};

    public Items_Panel() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(new GridBagLayout());
        setBackground(Color.PINK);

        itemsOptionsPanel = new ItemsOptions_Panel();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.0;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;

        add(itemsOptionsPanel, gridBagConstraints);

        defaultTableModel = new DefaultTableModel() {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };

        defaultTableModel.setColumnIdentifiers(columns);

        items_table = new JTable(){
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = "nothing";
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    //comment row, exclude heading
                    if(rowIndex != 0){
                        tip = getValueAt(rowIndex, colIndex).toString();
//                        System.out.println("Mouse point: " + p.x + " " + p.y);
                    }
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        };

        items_table.setModel(defaultTableModel);
        items_table.setRowHeight(100);

        itemsOptionsPanel.setTable(items_table, defaultTableModel);

        JScrollPane table_scrollPane = new JScrollPane(items_table);
        table_scrollPane.setBackground(Color.BLACK);

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;

        add(table_scrollPane, gridBagConstraints);
    }
}
