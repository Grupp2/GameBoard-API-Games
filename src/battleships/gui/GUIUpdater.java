package battleships.gui;


import battleships.backend.BattleShipsGameState;
import battleships.backend.Settings;
import game.api.GameState;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
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
        if (state.getPlayerInTurn().getName().equals(Settings.PLAYER_ONE_NAME)) {
            if (state.getDeployMovesRemaining() == 10) {
                contentPanel.setDeployPanel(playerOnePanel);
            }
        }
        updateButtonGraphics();
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
        Board board = state.getBoard();
        for (Component comp : panelToUpdate.getComponents()) {
            if (comp instanceof JButton) {
                BoardLocation locationToUpdate = getLocationById(board, comp.getName());
                if (locationToUpdate.getPieces() != null) {
                    List<GamePiece> pieces = locationToUpdate.getPieces();
                    for (GamePiece piece : pieces) {
                        if (piece.getId().equals(Settings.PIECE_SHIP))
                            comp.setBackground(Settings.PIECE_SHIP_COLOR);
                        if (piece.getId().equals(Settings.PIECE_ALREADYHIT))
                            comp.setBackground(Settings.PIECE_SHIPHIT_COLOR);
                    }

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
