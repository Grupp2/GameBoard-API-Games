package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import game.api.GameState;
import game.io.OutputUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import backend.OthelloGameState;

public class OthelloGameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private GameState gameState;
	private JPanel contentPane;
	private JPanel gameBoardPanel;
	private JLabel lblStatusText;
	private GameBoardListener gameBoardListener;
	private GraphicsHolder gh = new GraphicsHolder();
	private OthelloGuiInputUnit inputUnit;
	private boolean createGui = true;
	private Color highlightGreen = new Color(181, 130, 29 ,255);
	
	public OthelloGameFrame(OthelloGuiInputUnit inputUnit) {
		this.inputUnit = inputUnit;
		setBounds(1, 1, 605, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void notifyOfPublish(GameState state) {
		this.gameState = state;
		if (gameState.hasEnded())
			gameEndedRoutine();
		else {
			if (createGui) {
				buildGameFrame2();
				createGui = false;
			}
			placeGamePieces();
			updateTurnLabel();
			if (!gameState.getMessage().equals(""))
				JOptionPane.showMessageDialog(this, gameState.getMessage());
		}
	}
	
	private void updateTurnLabel() {
		lblStatusText.setText("player turn");
		if (gameState.getPlayerInTurn().getName().equals("P1"))
			lblStatusText.setIcon(new ImageIcon(gh.getPlayer1Piece()));
		else 
			lblStatusText.setIcon(new ImageIcon(gh.getPlayer2Piece()));
	}
	
	private void gameEndedRoutine() {
		lblStatusText.setText("The winner is: " + gameState.getWinner().getName());
		lblStatusText.setIcon(null);
	}
	
	public void buildGameFrame() {
		createGameBoardPanel();
		gameBoardListener = new GameBoardListener(gameBoardPanel, inputUnit);
		contentPane = new JPanel(new BorderLayout());
		lblStatusText = new JLabel(gameState.getPlayerInTurn().getName());
		lblStatusText.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblStatusText, BorderLayout.PAGE_START);
		contentPane.add(gameBoardPanel, BorderLayout.CENTER);
		setContentPane(contentPane);
		this.setVisible(true);
	}
	
	public void buildGameFrame2() {
		OthelloContentPanel contentPane = new OthelloContentPanel(gameState, inputUnit);
		setContentPane(contentPane.getContentPane());
		this.gameBoardPanel = contentPane.getGameBoardPanel();
		this.lblStatusText = contentPane.getStatusTextLabel();
		this.setVisible(true);
	}
	
	public JPanel getGameBoardPanel() {
		return gameBoardPanel;
	}
	
	public void setGameBoardPanel(JPanel gameBoardPanel) {
		this.gameBoardPanel = gameBoardPanel;
	}

	
	private void createGameBoardPanel() {
		gameBoardPanel = new GameBoardPanel(gameState);
	}
	
	public void setStatusLabelText(String str) {
		lblStatusText.setText(str);
	}
	
	public void placeGamePieces() {
		for (int i = 0; i < gameState.getBoard().getLocations().size();i++) {
			if (gameState.getBoard().getLocations().get(i).getPiece() != null) {
				if (gameState.getBoard().getLocations().get(i).getPiece().getId().equals("O"))
					((JButton)gameBoardPanel.getComponent(i)).setIcon(new ImageIcon(gh.getPlayer1Piece()));
				else if (gameState.getBoard().getLocations().get(i).getPiece().getId().equals("X"))
					((JButton)gameBoardPanel.getComponent(i)).setIcon(new ImageIcon(gh.getPlayer2Piece()));
				else
					gameBoardPanel.getComponent(i).setBackground(highlightGreen);
			} 
		}
	}
}
