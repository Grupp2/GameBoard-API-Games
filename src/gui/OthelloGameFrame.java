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
	
	public OthelloGameFrame(GameState gameState) {
		setBounds(1, 1, 800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPlayerPanels(gameState);
		createGameBoardPanel(gameState);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.add(p1Panel, BorderLayout.WEST);
		contentPane.add(p2Panel, BorderLayout.EAST);
		contentPane.add(gameBoardPanel, BorderLayout.CENTER);
	}
	
	private void createPlayerPanels(GameState gameState) {
		final int CONTROL_SIZE = 100;
		p1Panel = new PlayerPanelSimple(gameState.getPlayers().get(0), CONTROL_SIZE, CONTROL_SIZE);
		p2Panel = new PlayerPanelSimple(gameState.getPlayers().get(0), CONTROL_SIZE, CONTROL_SIZE);
	}
	
	private void createGameBoardPanel(GameState gameState) {
		gameBoardPanel = new GameBoardPanel(gameState);
	}
}
