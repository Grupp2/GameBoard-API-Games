package gui;

import java.util.Arrays;

import game.impl.GamePiece;
import game.impl.Player;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OthelloGameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Player player = new Player("P1", Arrays.asList(new GamePiece("X"), new GamePiece("X"), new GamePiece("X")));
	private JPanel contentPane;
	
	public OthelloGameFrame() {
		setBounds(100, 100, 825, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(new PlayerPanel(player, 150, 150));
		
	}

}
