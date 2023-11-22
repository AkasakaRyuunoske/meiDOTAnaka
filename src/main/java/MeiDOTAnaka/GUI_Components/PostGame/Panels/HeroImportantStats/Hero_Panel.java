package MeiDOTAnaka.GUI_Components.PostGame.Panels.HeroImportantStats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hero_Panel extends JPanel implements ActionListener {
    JButton hero_image;
    ImageIcon imageIcon;

    public Hero_Panel(){
        setBackground(Color.BLUE);

        hero_image = new JButton();
        imageIcon = new ImageIcon("src\\main\\java\\MeiDOTAnaka\\Resources\\Images\\shivallan_imba_hero_omg_volvo_fix_please.png");

        hero_image.setIcon(imageIcon);
        hero_image.addActionListener(this::actionPerformed);

        hero_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hero_image.setBackground(Color.GREEN);
                hero_image.setText("Ayee");
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                hero_image.setBackground(UIManager.getColor("control"));
            }
        });

        add(hero_image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hero_image) {
            System.out.println("Hero image was called");
        }
    }

    // getters  &&  setters
    public JButton getHero_image() {
        return hero_image;
    }

    public void setHero_image(JButton hero_image) {
        this.hero_image = hero_image;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
