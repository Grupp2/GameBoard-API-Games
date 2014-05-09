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
	private GameState gameState;
	private OthelloContentPanel contentPane;
	private GraphicsHolder gh = new GraphicsHolder();
	private OthelloGuiInputUnit inputUnit;
	private boolean createGui = true;
	private final Color highlightGreen = new Color(181, 230, 29 ,255);
	private final Color backgroundGreen = new Color(34, 177, 76, 255);
	private String player1gamePiece;
	private String player2gamePiece;
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
		this.player1gamePiece = gameState.getPlayers().get(0).getPieces().get(0).getId();
		this.player2gamePiece = gameState.getPlayers().get(1).getPieces().get(0).getId();
		this.player1Name = gameState.getPlayers().get(0).getName();
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
				contentPane.getGameBoardPanel().getComponent(i).setBackground(backgroundGreen);
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
		if (!(gameState instanceof OthelloGameState)) {
			contentPane.getUtilityPanel().getBtnUndo().setEnabled(false);
			return;
		} else {
			if (((OthelloGameState) gameState).canUndo())
				contentPane.getUtilityPanel().getBtnUndo().setEnabled(true);
			else
				contentPane.getUtilityPanel().getBtnUndo().setEnabled(false);
		}
	}
}
