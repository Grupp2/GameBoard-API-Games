package battleships.gui;

import battleships.gui.panels.StatusPanel.StatusPanel;
import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel deployPanel;
    private StatusPanel statusPanel;
    private JPanel normalPanel;
    private JPanel currentBoardPanel;

    public ContentPanel(BattleShipsInputUnit inputUnit, JPanel deployPanel){
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
        revalidate();
        repaint();
    }

    public void displayDeployPanel(){
        removeCurrentBoardPanel();
        setCurrentBoardPanel(deployPanel);
    }

    public void displayNormalPanel(){
        removeCurrentBoardPanel();
        setCurrentBoardPanel(normalPanel);
    }

    public void setNormalPanel(JPanel panel) {
        this.normalPanel = panel;
    }

    public void setDeployPanel(JPanel deployPanel) {
        this.deployPanel = deployPanel;
    }

    public void setTurnMessage(String message){
        statusPanel.setTurnMessage(message);
    }

    public void setNotificationMessage(String message){
        statusPanel.setNotificationMessage(message);
    }
}
