package battleships.gui;


import battleships.backend.BattleShipsGameState;
import battleships.backend.Settings;
import battleships.gui.panels.BattleShipsPanel;
import game.api.GameState;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import generics.GameUpdatable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIUpdater implements GameUpdatable{

    private ContentPanel contentPanel;
    private JPanel playerOnePanel;
    private JPanel playerTwoPanel;
    private BattleShipsGameState state;
    private BattleShipsPanel normalGamePanel;

    public GUIUpdater(ContentPanel panel, JPanel playerOnePanel, JPanel playerTwoPanel, BattleShipsPanel normalGamePanel){
        this.contentPanel = panel;
        this.playerOnePanel = playerOnePanel;
        this.playerTwoPanel = playerTwoPanel;
        this.normalGamePanel = normalGamePanel;
        contentPanel.setNormalPanel(normalGamePanel);
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
        if (state.getPlayerInTurn().getName().equals(Settings.PLAYER_ONE_NAME)) {
            if (state.getDeployMovesRemaining() == 10) {
                contentPanel.setDeployPanel(playerOnePanel);
            }
        }
        if(((BattleShipsGameState)gameState).getIsDeployMode()){
            contentPanel.displayDeployPanel();
        }
        else {
            contentPanel.displayNormalPanel();
            contentPanel.setPreferredSize(new Dimension(1205, 600));
        }
        updateButtonGraphics();
        if (state.hasEnded()) {
            disablePanelComponents(contentPanel); //doesn't work
            contentPanel.setNotificationMessage(state.getWinner().getName() + " has won!");
        }
    }
    private void disablePanelComponents(JPanel panel) {
        for (Component comp : panel.getComponents())
            if (comp instanceof JButton) {
                JButton butt = (JButton) comp;
                for (ActionListener al : butt.getActionListeners()) {
                    butt.removeActionListener(al);
                }
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
            updatePanel(normalGamePanel.getPlayerOnePanel());
            updatePanel(normalGamePanel.getPlayerTwoPanel());
        }

    }

    private void updatePanel(JPanel panelToUpdate) {
        Board board = state.getBoard();
        for (Component comp : panelToUpdate.getComponents()) {
            if (comp instanceof JButton) {
                BoardLocation locationToUpdate = getLocationById(board, comp.getName());

                if (locationToUpdate.getPiece() != null) {
                    GamePiece piece = locationToUpdate.getPiece();

                        if (piece.getId().charAt(Settings.PIECE_TYPE_INDEX) == Settings.SHIP_ID)
                            if (state.getIsDeployMode())
                                comp.setBackground(Settings.PIECE_SHIP_COLOR);
                            else
                                comp.setBackground(Settings.TILE_COLOR);

                        else if (piece.getId().equals(Settings.PIECE_HIT_ID))
                            comp.setBackground(Settings.PIECE_SHIPHIT_COLOR);

                        else if(piece.getId().equals(Settings.PIECE_MISS_ID))
                            comp.setBackground(Settings.PIECE_MISS_COLOR);

                }

            }
        }
    }

    private BoardLocation getLocationById(Board board, String id) {
        List<BoardLocation> locations = board.getLocations();

        for (int i = 0; i < locations.size(); i++)
            if (locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }
}
