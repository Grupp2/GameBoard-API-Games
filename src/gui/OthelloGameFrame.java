package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;

import game.api.GameState;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import backend.OthelloGameState;

public class OthelloGameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private OthelloGameState gameState;
	private OthelloContentPanel contentPane;
	private JPanel gameBoardPanel;
	private GraphicsHolder gh = new GraphicsHolder();
	private OthelloGuiInputUnit inputUnit;
	private boolean createGui = true;
	private Color highlightGreen = new Color(181, 130, 29 ,255);
	private final String player1gamePiece = "O";
	private final String player2gamePiece = "X";
	private final String player1Name = "P1";
	
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
			if (!gameState.getMessage().equals(""))
				contentPane.getStatusPanel().getStatusTextLabel().setText(gameState.getMessage());
			else
				contentPane.getStatusPanel().getStatusTextLabel().setText("");
		}
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
		contentPane.getStatusPanel().getStatusTextLabel().setText("The winner is: " + gameState.getWinner().getName());
//		lblStatusText.setIcon(null);
	}
	
	public void buildGameFrame() {
		contentPane = new OthelloContentPanel(gameState, inputUnit);
		setContentPane(this.contentPane.getContentPane());
		this.gameBoardPanel = contentPane.getGameBoardPanel();
		addFrameListener();
		this.setVisible(true);
	}
	
	private void addFrameListener() {
		this.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsAdapter(){
			@Override
            public void ancestorResized(HierarchyEvent e) {
            	placeGamePieces();
            }           
		});
	}
	
	public JPanel getGameBoardPanel() {
		return gameBoardPanel;
	}
	
	public void setGameBoardPanel(JPanel gameBoardPanel) {
		this.gameBoardPanel = gameBoardPanel;
	}
	
	public void setStatusLabelText(String str) {
		contentPane.getStatusPanel().getStatusTextLabel().setText(str);
	}
	
	public void placeGamePieces() {
		for (int i = 0; i < gameState.getBoard().getLocations().size();i++) {
			if (gameState.getBoard().getLocations().get(i).getPiece() != null) {
				if (gameState.getBoard().getLocations().get(i).getPiece().getId().equals(player1gamePiece)) {
					((JButton)gameBoardPanel.getComponent(i)).setIcon(new ImageIcon(gh.getPlayer1Piece(((JButton)gameBoardPanel.getComponent(i)).getSize())));
					((JButton)gameBoardPanel.getComponent(i)).setFocusPainted(false);
				} else if (gameState.getBoard().getLocations().get(i).getPiece().getId().equals(player2gamePiece)) {
					((JButton)gameBoardPanel.getComponent(i)).setIcon(new ImageIcon(gh.getPlayer2Piece(((JButton)gameBoardPanel.getComponent(i)).getSize())));
					((JButton)gameBoardPanel.getComponent(i)).setFocusPainted(false);
				} else
					gameBoardPanel.getComponent(i).setBackground(highlightGreen);
			} else{
				((JButton)gameBoardPanel.getComponent(i)).setIcon(null);
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
