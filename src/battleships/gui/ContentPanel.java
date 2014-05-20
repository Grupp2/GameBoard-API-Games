package battleships.gui;


import battleships.BattleShipsInputUnit;
import battleships.gui.panels.BattleshipDeployPanel;
import battleships.gui.panels.StatusPanel.StatusPanel;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel{

    private BattleshipDeployPanel deployPanel;

    public ContentPanel(BattleShipsInputUnit inputUnit, BattleshipDeployPanel deployPanel){
        this.deployPanel = deployPanel;
        setLayout(new BorderLayout());
        add(new StatusPanel(), BorderLayout.PAGE_START);
    }

    public void displayPlayerOneBoard(){
        removeAll();
        add(deployPanel);
    }

    public void displayPlayerTwoBoard(){
        removeAll();
        add(deployPanel);
    }

}
