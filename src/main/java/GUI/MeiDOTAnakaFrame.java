package GUI;

import GUI.Panels.DraftPanel;
import GUI.Panels.HeroPanel;
import GUI.Panels.PlayerInfoPanel;

import javax.swing.*;
import java.awt.*;

public class MeiDOTAnakaFrame extends JFrame {
    DraftPanel draftPanel;
    DraftPanel draftPanel1; //#todo placeholder, don't forget to use proper layour manager
    HeroPanel heroPanel;
    PlayerInfoPanel playerInfoPanel;

    public MeiDOTAnakaFrame(){
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        setTitle("MeiDOTAnata - Your cringe assistant wirten by cringe ukrainian refugee");

        draftPanel = new DraftPanel();
        draftPanel1 = new DraftPanel();
        heroPanel = new HeroPanel();
        playerInfoPanel = new PlayerInfoPanel();

        add(draftPanel);
        add(playerInfoPanel);
        add(draftPanel1);
        add(heroPanel);

        setVisible(true);

        System.out.println("Initiated");
    }

    public void updatePanels(String apm, String gpm, String xpm, String networth){
        playerInfoPanel.updateData(apm, gpm, xpm, networth);
    }

    public void updateHeroCurrentHP(int newCurrentHp){
        heroPanel.updateHeroCurrentHP(newCurrentHp);
    }

    public void updateHeroMaxHP(int newMaxHP){
        heroPanel.updateHeroMaxHP(newMaxHP);
    }

    public void updateHeroMaxMP(int newMaxMP){
        heroPanel.updateHeroMaxMP(newMaxMP);
    }

    public void updateHeroCurrentMP(int newCurrentMP){
        heroPanel.updateHeroCurrentMP(newCurrentMP);
    }

    public void updateHeroLvl(int newLvl){
        heroPanel.updateHeroLvl(newLvl);
    }
}
