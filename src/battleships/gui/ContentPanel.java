package battleships.gui;


import battleships.gui.panels.BattleshipDeployPanel;
import battleships.gui.panels.StatusPanel.StatusPanel;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel{

    private BattleshipDeployPanel deployPanel;
    private StatusPanel statusPanel;

    public ContentPanel(BattleShipsInputUnit inputUnit, BattleshipDeployPanel deployPanel){
        this.deployPanel = deployPanel;
        this.statusPanel = new StatusPanel();
        setLayout(new BorderLayout());
        add(statusPanel, BorderLayout.PAGE_START);
    }


    public void displayDeployPanel(){
        add(deployPanel, BorderLayout.CENTER);
    }


    public void setTurnMessage(String message){
        statusPanel.setTurnMessage(message);
    }

    public void setNotificationMessage(String message){
        statusPanel.setNotificationMessage(message);
    }

}
