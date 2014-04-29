package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import game.api.GameState;
import game.io.OutputUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OthelloGameFrame extends JFrame implements OutputUnit {

	private static final long serialVersionUID = 1L;
	private GameState gameState;
	private JPanel contentPane;
	private JPanel p1Panel;
	private JPanel p2Panel;
	private JPanel gameBoardPanel;
	private JLabel lblStatusText;
	private JButton btnPassTurn;
	private GameBoardListener gameBoardListener;
	private GraphicsHolder gh = new GraphicsHolder();
	private boolean run = true;
	
	public OthelloGameFrame() {
		
	}
	
	private void buildGameFrame() {
		setBounds(1, 1, 675, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPlayerPanels();
		createGameBoardPanel();
//		gameBoardListener = new GameBoardListener(gameBoardPanel, gameState, gh);
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		lblStatusText = new JLabel("Game started!");
		lblStatusText.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPassTurn = new JButton("Pass turn!");
		contentPane.add(lblStatusText, BorderLayout.PAGE_START);
		contentPane.add(p1Panel, BorderLayout.LINE_START);
		contentPane.add(gameBoardPanel, BorderLayout.CENTER);
		contentPane.add(p2Panel, BorderLayout.LINE_END);
		contentPane.add(btnPassTurn, BorderLayout.PAGE_END);
		this.run = false;
		this.repaint();
	}
	
	public JPanel getGameBoardPanel() {
		return gameBoardPanel;
	}
	
	public void setGameBoardPanel(JPanel gameBoardPanel) {
		this.gameBoardPanel = gameBoardPanel;
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
	
	public void setStatusLabelText(String str) {
		lblStatusText.setText(str);
	}

	@Override
	public void publish(GameState gameState) {
		this.gameState = gameState;
		if (run)
			buildGameFrame();
	}
}
