package battleships.gui;


import battleships.BattleShipsInputUnit;
import battleships.gui.panels.BattleshipGamePanels;

import javax.swing.*;

public class ContentPanel extends JPanel{

    private BattleshipGamePanels gamePanels;

    public ContentPanel(BattleShipsInputUnit inputUnit, BattleshipGamePanels gamePanels){
        this.gamePanels = gamePanels;
    }

    public void displayPlayerOneBoard(){
        removeAll();
        add(gamePanels.getPlayer1());
    }

    public void displayPlayerTwoBoard(){
        removeAll();
        add(gamePanels.getPlayer2());
    }

}
