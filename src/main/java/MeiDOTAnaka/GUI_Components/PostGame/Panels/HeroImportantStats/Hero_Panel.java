package MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroImportantStats;

import javax.swing.*;
import java.awt.*;

public class Hero_Panel extends JPanel {
    JLabel hero_image;
    ImageIcon imageIcon;

    public Hero_Panel(){
        setBackground(Color.BLUE);

        hero_image = new JLabel();
        imageIcon = new ImageIcon("src\\main\\java\\MeiDOTAnaka\\Resources\\Images\\shivallan_imba_hero_omg_volvo_fix_please.png");

        hero_image.setIcon(imageIcon);

        add(hero_image);
    }

    public JLabel getHero_image() {
        return hero_image;
    }

    public void setHero_image(JLabel hero_image) {
        this.hero_image = hero_image;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
