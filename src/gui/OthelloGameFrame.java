package gui;

import game.api.GameState;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OthelloGameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel p1Panel;
	private JPanel p2Panel;
	
	public OthelloGameFrame(GameState gameState) {
		setBounds(1, 1, 800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		p1Panel = new PlayerPanelVertical(gameState.getPlayers().get(0), 150, 150);
		p2Panel = new PlayerPanelVertical(gameState.getPlayers().get(1), 150, 150);
		contentPane.add(p1Panel);
		setCtrlBounds();
	}
	
	private void setCtrlBounds(){
		p1Panel.setBounds(10, 10, 150, 150 * 32);
		p2Panel.setBounds(640, 10, 150, 150 * 32);
	}

}
