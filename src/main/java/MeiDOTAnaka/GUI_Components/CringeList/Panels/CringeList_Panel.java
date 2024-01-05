package MeiDOTAnaka.GUI_Components.CringeList.Panels;

import javax.swing.*;
import java.awt.*;

public class CringeList_Panel extends JPanel {
    public CringeList_Panel(){
        setBackground(Color.DARK_GRAY);
        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setContentType("text/html");
        jEditorPane.setText("<html>" +
                                "<body>" +
                                    "<h1>Nee watashi wa nido to kurai kao shinai yo</h1>" +

                                    "<br>" +
                                    "<br>" +

                                    "<h2 style='color:blue;'>Yay actually works!</h2>" +

                                    "<br>" +
                                    "<br>" +

                                    "<div style='display:grid; " +
                                        "grid-template-columns: auto auto auto;" +
                                        "background-color: #2196F3;" +
                                        "padding: 10px;'>" +
                                            "<h2>I am an item: 1</h2>" +
                                            "<h2>I am an item: 2</h2>" +
                                            "<h2>I am an item: 3</h2>" +
                                            "<h2>I am an item: 4</h2>" +
                                            "<h2>I am an item: 5</h2>" +
                                            "<h2>I am an item: 6</h2>" +
                                            "<h2>I am an item: 7</h2>" +
                                    "</div>" +
                                    "" +
                                "</body>" +
                            "</html>");

        add(jEditorPane);
    }
}
