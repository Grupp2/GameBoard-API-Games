package battleships.gui;


import battleships.backend.BattleShipsGameState;
import battleships.backend.Settings;
import game.api.GameState;
import generics.GameUpdatable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUIUpdater implements GameUpdatable{

    private ContentPanel contentPanel;
    private JPanel playerOnePanel;
    private JPanel playerTwoPanel;
    private BattleShipsGameState state;

    public GUIUpdater(ContentPanel panel, JPanel playerOnePanel, JPanel playerTwoPanel){
        this.contentPanel = panel;
        this.playerOnePanel = playerOnePanel;
        this.playerTwoPanel = playerTwoPanel;
    }

    @Override
    public void update(GameState gameState) {
        this.state = (BattleShipsGameState) gameState;
        updateMessages(gameState);
        updateGameBoard(gameState);

    }

    private void updateMessages(GameState gameState){
        contentPanel.setTurnMessage(gameState.getPlayerInTurn().getName());
        contentPanel.setNotificationMessage(gameState.getMessage());
    }

    private void updateGameBoard(GameState gameState){
        if(((BattleShipsGameState)gameState).getIsDeployMode()){
            contentPanel.displayDeployPanel();
        }
        else {
            contentPanel.displayNormalPanel();
        }
    }

    private void updateButtonGraphics() {
        List<JButton> panelButtons = new ArrayList<JButton>();
        JPanel panelToUpdate;
        if (state.getIsDeployMode()) {
            if (state.getPlayerInTurn().getName().equals("P1")) {
                panelToUpdate = playerTwoPanel;
            } else {
                panelToUpdate = playerOnePanel;
            }
            updatePanel(panelToUpdate);
        } else {
            updatePanel(playerOnePanel);
            updatePanel(playerTwoPanel);
        }

    }

    private void updatePanel(JPanel panelToUpdate) {
        for (Component comp : panelToUpdate.getComponents()) {
            if (comp instanceof JButton) {

            }
        }
    }
}
