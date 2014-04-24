package gui;

import java.awt.BorderLayout;
import game.api.GameState;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OthelloGameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel p1Panel;
	private JPanel p2Panel;
	private JPanel gameBoardPanel;
	private GameBoardListener gameBoardListener;
	
	public OthelloGameFrame(GameState gameState) {
		setBounds(1, 1, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		createPlayerPanels(gameState);
		createGameBoardPanel(gameState);
		gameBoardListener = new GameBoardListener(gameBoardPanel);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.add(p1Panel, BorderLayout.WEST);
		contentPane.add(gameBoardPanel, BorderLayout.CENTER);
		contentPane.add(p2Panel, BorderLayout.EAST);
	}
	
	private void createPlayerPanels(GameState gameState) {
		final int CONTROL_SIZE = 100;
		p1Panel = new PlayerPanelSimple(gameState.getPlayers().get(0), CONTROL_SIZE, CONTROL_SIZE);
		p2Panel = new PlayerPanelSimple(gameState.getPlayers().get(1), CONTROL_SIZE, CONTROL_SIZE);
	}
	
	private void createGameBoardPanel(GameState gameState) {
		gameBoardPanel = new GameBoardPanel(gameState);
	}
	
	public String getLastLocation() {
		return gameBoardListener.getLastMove();
	}
}
