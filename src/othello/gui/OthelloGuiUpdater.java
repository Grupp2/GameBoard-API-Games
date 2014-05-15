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
import gui.GameUpdatable;

public class OthelloGuiUpdater implements GameUpdatable {
	private OthelloContentPanel contentPane;
	private GameState gameState;

	private final int largeStatusFont = 20;
	private final int normalStatusFont = 15;
	private GraphicsHolder graphicsHolder = new GraphicsHolder();
	private final Color backgroundGreen = new Color(34, 177, 76, 255);

	public OthelloGuiUpdater(OthelloContentPanel contentPane) {
		this.contentPane = contentPane;
        addFrameListener();
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

    private void addFrameListener() {
        this.contentPane.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
            public void ancestorResized(HierarchyEvent e) {
                placeGamePieces();
            }
        });
    }


	private void updateStatusTextLabel() {
		updateStatusTextLabelFontSize(normalStatusFont);
		contentPane.getStatusPanel().getStatusTextLabel().setText(gameState.getMessage());
	}
	
	private void updateTurnLabel() {
		if (gameState.getPlayerInTurn().getName().equals(Settings.PLAYER_ONE_NAME)) {
			contentPane.getStatusPanel().getPlayerInfoLabel().setText("player 1 turn");
			contentPane.getStatusPanel().getPlayerInfoLabel().setIcon(new ImageIcon(graphicsHolder.getPlayer1Piece()));
		} else {
			contentPane.getStatusPanel().getPlayerInfoLabel().setText("player 2 turn");
			contentPane.getStatusPanel().getPlayerInfoLabel().setIcon(new ImageIcon(graphicsHolder.getPlayer2Piece()));
		}
	}
	
	private void gameEndedRoutine() {
		placeGamePieces();
		updateStatusTextLabelFontSize(largeStatusFont);
		contentPane.getStatusPanel().getStatusTextLabel().setText("The winner is: " + gameState.getWinner().getName());
	}
	
	private void updateStatusTextLabelFontSize(int fontSize) {
		contentPane.getStatusPanel().getStatusTextLabel().setFont(new Font("Tahoma", Font.PLAIN, fontSize));
	}
	
	public void setStatusLabelText(String str) {
		contentPane.getStatusPanel().getStatusTextLabel().setText(str);
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
        toggleUndoButton();
	}

    private boolean isPlayerOnePiece(GamePiece piece){
        return piece.getId().equals(Settings.PLAYER_ONE_PIECE_ID);
    }

    private boolean isPlayerTwoPiece(GamePiece piece){
        return piece.getId().equals(Settings.PLAYER_TWO_PIECE_ID);
    }

	private void toggleUndoButton() {
		if (!(gameState instanceof OthelloGameFacade)) {
			contentPane.getUtilityPanel().getBtnUndo().setEnabled(false);
			return;
		} else {
			if (((OthelloGameFacade) gameState).canUndo())
				contentPane.getUtilityPanel().getBtnUndo().setEnabled(true);
			else
				contentPane.getUtilityPanel().getBtnUndo().setEnabled(false);
		}
	}
}
