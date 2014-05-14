package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.util.List;

import game.api.GameState;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import gui.graphics.GraphicsHolder;
import gui.panels.OthelloContentPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import backend.OthelloGameFacade;

public class OthelloGameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private GameState gameState;
	private OthelloContentPanel contentPane;
	private GraphicsHolder graphicsHolder = new GraphicsHolder();
	private OthelloGuiInputUnit inputUnit;
	private boolean createGui = true;
	private final Color backgroundGreen = new Color(34, 177, 76, 255);
	private String player1gamePieceId;
	private String player2gamePieceId;
	private String player1Name;
	private final int largeStatusFont = 20;
	private final int normalStatusFont = 15;
	
	public OthelloGameFrame(OthelloGuiInputUnit inputUnit) {
		this.inputUnit = inputUnit;
		setBounds(1, 1, 600, 700);
		setMinimumSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void notifyOfPublish(GameState state) {
		this.gameState = state;
		if (gameState.hasEnded())
			gameEndedRoutine();
		else {
			if (createGui) {
				buildGameFrame();
				setupPlayerInfo();
				createGui = false;
			}
			placeGamePieces();
			updateTurnLabel();
			updateStatusTextLabel();
		}
	}
	
	private void buildGameFrame() {
		contentPane = new OthelloContentPanel(gameState, inputUnit);
		setContentPane(this.contentPane.getContentPane());
		addFrameListener();
		this.setVisible(true);
	}
	
	private void addFrameListener() {
		this.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsAdapter(){ public void ancestorResized(HierarchyEvent e) { placeGamePieces(); }});
	}
	
	private void setupPlayerInfo() {
		this.player1gamePieceId = gameState.getPlayers().get(0).getPieces().get(0).getId();
		this.player2gamePieceId = gameState.getPlayers().get(1).getPieces().get(0).getId();
		this.player1Name = gameState.getPlayers().get(0).getName();
	}

	private void updateStatusTextLabel() {
		updateStatusTextLabelFontSize(normalStatusFont);
		contentPane.getStatusPanel().getStatusTextLabel().setText(gameState.getMessage());
	}
	
	private void updateTurnLabel() {
		if (gameState.getPlayerInTurn().getName().equals(player1Name)) {
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
            else{
                currentButton.setIcon(null);
            }
        }

        toggleUndoButton();
	}

    private boolean isPlayerOnePiece(GamePiece piece){
        return piece.getId().equals(player1gamePieceId);
    }

    private boolean isPlayerTwoPiece(GamePiece piece){
        return piece.getId().equals(player2gamePieceId);
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
