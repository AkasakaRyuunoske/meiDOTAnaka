package MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroImportantStats;

import javax.swing.*;
import java.awt.*;

public class HeroImportantStats_Panel extends JPanel {
    public Hero_Panel hero_panel;
    public HeroStats_Panel heroStats_panel;

    public HeroImportantStats_Panel(){
        setLayout(new GridLayout(1,2));
        setBackground(Color.PINK);

        hero_panel = new Hero_Panel();
        heroStats_panel = new HeroStats_Panel();

        add(hero_panel);
        add(heroStats_panel);
        hero_panel.hero_image.repaint();
    }
}
