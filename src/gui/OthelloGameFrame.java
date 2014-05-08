package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import game.api.GameState;
import gui.graphics.GraphicsHolder;
import gui.panels.OthelloContentPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import backend.OthelloGameState;

public class OthelloGameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private OthelloGameState gameState;
	private OthelloContentPanel contentPane;
	private GraphicsHolder gh = new GraphicsHolder();
	private OthelloGuiInputUnit inputUnit;
	private boolean createGui = true;
	private Color highlightGreen = new Color(181, 130, 29 ,255);
	private final String player1gamePiece = "O";
	private final String player2gamePiece = "X";
	private final String player1Name = "P1";
	private final int largeStatusFont = 20;
	private final int normalStatusFont = 15;
	
	public OthelloGameFrame(OthelloGuiInputUnit inputUnit) {
		this.inputUnit = inputUnit;
		setBounds(1, 1, 600, 600);
		setMinimumSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void notifyOfPublish(GameState state) {
		this.gameState = (OthelloGameState)state;
		if (gameState.hasEnded())
			gameEndedRoutine();
		else {
			if (createGui) {
				buildGameFrame();
				createGui = false;
			}
			placeGamePieces();
			updateTurnLabel();
			updateStatusTextLabel();
		}
	}
	
	public void buildGameFrame() {
		contentPane = new OthelloContentPanel(gameState, inputUnit);
		setContentPane(this.contentPane.getContentPane());
		addFrameListener();
		this.setVisible(true);
	}
	
	private void addFrameListener() {
		this.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsAdapter(){ public void ancestorResized(HierarchyEvent e) { placeGamePieces(); }});
	}

	private void updateStatusTextLabel() {
		updateStatusTextLabelFontSize(normalStatusFont);
		contentPane.getStatusPanel().getStatusTextLabel().setText(gameState.getMessage());
	}
	
	private void updateTurnLabel() {
		if (gameState.getPlayerInTurn().getName().equals(player1Name)) {
			contentPane.getStatusPanel().getPlayerInfoLabel().setText("player 1 turn");
			contentPane.getStatusPanel().getPlayerInfoLabel().setIcon(new ImageIcon(gh.getPlayer1Piece()));
		} else {
			contentPane.getStatusPanel().getPlayerInfoLabel().setText("player 2 turn");
			contentPane.getStatusPanel().getPlayerInfoLabel().setIcon(new ImageIcon(gh.getPlayer2Piece()));
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
		for (int i = 0; i < gameState.getBoard().getLocations().size();i++) {
			if (gameState.getBoard().getLocations().get(i).getPiece() != null) {
				if (gameState.getBoard().getLocations().get(i).getPiece().getId().equals(player1gamePiece)) {
					((JButton)contentPane.getGameBoardPanel().getComponent(i)).setIcon(new ImageIcon(gh.getPlayer1Piece(((JButton)contentPane.getGameBoardPanel().getComponent(i)).getSize())));
					((JButton)contentPane.getGameBoardPanel().getComponent(i)).setFocusPainted(false);
				} else if (gameState.getBoard().getLocations().get(i).getPiece().getId().equals(player2gamePiece)) {
					((JButton)contentPane.getGameBoardPanel().getComponent(i)).setIcon(new ImageIcon(gh.getPlayer2Piece(((JButton)contentPane.getGameBoardPanel().getComponent(i)).getSize())));
					((JButton)contentPane.getGameBoardPanel().getComponent(i)).setFocusPainted(false);
				} else
					contentPane.getGameBoardPanel().getComponent(i).setBackground(highlightGreen);
			} else{
				((JButton)contentPane.getGameBoardPanel().getComponent(i)).setIcon(null);
			}
		}
		toggleUndoButton();
	}
	
	private void toggleUndoButton() {
		if (gameState.canUndo())
			contentPane.getUtilityPanel().getBtnUndo().setEnabled(true);
		else
			contentPane.getUtilityPanel().getBtnUndo().setEnabled(false);
	}
}
