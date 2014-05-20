package othello.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import othello.backend.OthelloGameFacade;
import othello.backend.Settings;
import othello.gui.graphics.GraphicsHolder;
import game.api.GameState;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import generics.GameUpdatable;

public class OthelloGuiUpdater implements GameUpdatable {
	private OthelloContentPanel contentPane;
	private GameState gameState;

	private final int LARGE_STATUS_FONT = 20;
	private final int NORMAL_STATUS_FONT = 15;

	private GraphicsHolder graphicsHolder = new GraphicsHolder();
	private final Color backgroundGreen = new Color(34, 177, 76, 255);

	public OthelloGuiUpdater(OthelloContentPanel contentPane) {
		this.contentPane = contentPane;
        addFrameListener();
	}

    private void addFrameListener() {
        this.contentPane.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
            public void ancestorResized(HierarchyEvent e) {
                placeGamePieces();
            }
        });
    }

	@Override
	public void update(GameState gameState) {
		this.gameState = gameState;

        if (gameState.hasEnded())
			gameEndedRoutine();
		else {
			placeGamePieces();
			updateTurnLabel();
			updateStatusTextLabel();
		}
	}


    private void gameEndedRoutine() {
        placeGamePieces();
        updateStatusTextLabelFontSize(LARGE_STATUS_FONT);
        contentPane.setMessageLabel("The winner is: " + gameState.getWinner().getName());
    }

	private void updateStatusTextLabel() {
		updateStatusTextLabelFontSize(NORMAL_STATUS_FONT);
        contentPane.setMessageLabel(gameState.getMessage());
	}
	
	private void updateTurnLabel() {
        if (isPlayerOnesTurn())
            contentPane.setTurnLabel(new ImageIcon(graphicsHolder.getPlayer1Piece()), "Player 1 turn");
        else
            contentPane.setTurnLabel(new ImageIcon(graphicsHolder.getPlayer2Piece()), "Player 2 turn");
    }

	private void updateStatusTextLabelFontSize(int fontSize) {
		contentPane.setMessageFont(new Font("Tahoma", Font.PLAIN, fontSize));
	}

    private void updateUndoButton() {
        contentPane.setUndoButtonEnabled(((OthelloGameFacade) gameState).canUndo());
    }

	private void placeGamePieces() {
        List<BoardLocation> locations = gameState.getBoard().getLocations();
        JButton currentButton;
        ImageIcon iconForButton;

        for (int i = 0; i < locations.size();i++) {

            currentButton = (JButton)contentPane.getGameBoardPanel().getComponent(i);
            GamePiece currentPiece = locations.get(i).getPiece();

            if (currentPiece != null) {
                iconForButton = null;

                if (isPlayerOnePiece(currentPiece))
                    iconForButton = new ImageIcon(graphicsHolder.getPlayer1Piece(currentButton.getSize()));
                else if (isPlayerTwoPiece(currentPiece))
                    iconForButton = new ImageIcon(graphicsHolder.getPlayer2Piece(currentButton.getSize()));

                currentButton.setBackground(backgroundGreen);
                currentButton.setIcon(iconForButton);
                currentButton.setFocusPainted(false);
            }
            else
                currentButton.setIcon(null);
        }
        updateUndoButton();
	}

    private boolean isPlayerOnePiece(GamePiece piece){
        return piece.getId().equals(Settings.PLAYER_ONE_PIECE_ID);
    }

    private boolean isPlayerTwoPiece(GamePiece piece){
        return piece.getId().equals(Settings.PLAYER_TWO_PIECE_ID);
    }

    private boolean isPlayerOnesTurn(){
        return gameState.getPlayerInTurn().getName().equals(Settings.PLAYER_ONE_NAME);
    }
}
