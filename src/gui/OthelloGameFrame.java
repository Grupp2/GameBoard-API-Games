package gui;

import java.awt.BorderLayout;

import game.api.GameState;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OthelloGameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GameState gameState;
	private JPanel contentPane;
	private JPanel p1Panel;
	private JPanel p2Panel;
	private JPanel gameBoardPanel;
	private GameBoardListener gameBoardListener;
	private GraphicsHolder gh = new GraphicsHolder();
	
	public OthelloGameFrame(GameState gameState) {
		this.gameState = gameState;
		setBounds(1, 1, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		createPlayerPanels();
		createGameBoardPanel();
		gameBoardListener = new GameBoardListener(gameBoardPanel);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.add(p1Panel, BorderLayout.WEST);
		contentPane.add(gameBoardPanel, BorderLayout.CENTER);
		contentPane.add(p2Panel, BorderLayout.EAST);
		placeGamePieces();
	}
	
	private void placeGamePieces() {
		for (int i=0; i < gameState.getBoard().getLocations().size(); i++) {
			if (gameState.getBoard().getLocations().get(i).getPiece()!=null)
				if (gameState.getBoard().getLocations().get(i).getPiece().equals("X"))
					if (gameBoardPanel.getComponent(i) instanceof JButton)
						((JButton)gameBoardPanel.getComponent(i)).setIcon((Icon) gh.getPlayer1Piece());
				else 
					if (gameBoardPanel.getComponent(i) instanceof JButton)
						((JButton)gameBoardPanel.getComponent(i)).setIcon((Icon) gh.getPlayer2Piece());
			else
				if (gameBoardPanel.getComponent(i) instanceof JButton)
					((JButton)gameBoardPanel.getComponent(i)).setIcon((Icon) gh.getBlankBoardPiece());
		}
	}
	
	private void createPlayerPanels() {
		final int CONTROL_SIZE = 100;
		p1Panel = new PlayerPanelSimple(gameState.getPlayers().get(0), CONTROL_SIZE, CONTROL_SIZE);
		p2Panel = new PlayerPanelSimple(gameState.getPlayers().get(1), CONTROL_SIZE, CONTROL_SIZE);
	}
	
	private void createGameBoardPanel() {
		gameBoardPanel = new GameBoardPanel(gameState);
	}
	
	public String getLastLocation() {
		return gameBoardListener.getLastMove();
	}
}
