package battleships.gui;


import battleships.gui.panels.BattleshipDeployPanel;
import battleships.gui.panels.StatusPanel.StatusPanel;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel{

    private BattleshipDeployPanel deployPanel;
    private StatusPanel statusPanel;

    private JPanel currentBoardPanel;

    public ContentPanel(BattleShipsInputUnit inputUnit, BattleshipDeployPanel deployPanel){
        this.deployPanel = deployPanel;
        this.statusPanel = new StatusPanel();
        setLayout(new BorderLayout());
        add(statusPanel, BorderLayout.PAGE_START);
    }

    private void removeCurrentBoardPanel(){
        if(currentBoardPanel != null){
            remove(currentBoardPanel);
            currentBoardPanel = null;
        }
    }

    private void setCurrentBoardPanel(JPanel panel){
        currentBoardPanel = panel;
        add(panel, BorderLayout.CENTER);
    }


    public void displayDeployPanel(){
        removeCurrentBoardPanel();
        setCurrentBoardPanel(deployPanel);
    }

    public void displayNormalPanel(){
        removeCurrentBoardPanel();
        setCurrentBoardPanel(null);
    }

    public void setTurnMessage(String message){
        statusPanel.setTurnMessage(message);
    }

    public void setNotificationMessage(String message){
        statusPanel.setNotificationMessage(message);
    }

}
