package gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameSelectorPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnGameOne;
	private JButton btnGameTwo;
	private final int gridRows = 2;
	private final int gridColumns = 1;
	
	public GameSelectorPanel() {
		this.btnGameOne = new JButton("Othello Game");
		this.btnGameTwo = new JButton("BattleShips Game");
		createPanel();
	}
	
	private void createPanel() {
		setLayout(new GridLayout(gridRows, gridColumns));
		add(btnGameOne);
		add(btnGameTwo);
	}
	
	public GameSelectorPanel getPanel() {
		return this;
	}
	
	public JButton getBtnGameOne() {
		return btnGameOne;
	}

	public JButton getBtnGameTwo() {
		return btnGameTwo;
	}

}
