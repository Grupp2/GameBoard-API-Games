package battleships.gui.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import battleships.backend.BattleShipsGameState;
import battleships.gui.BattleShipsInputUnit;

public class BattleshipsUtilityPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnNew;
	private JButton btnExit;
	private JButton btnAdd;
	
	public BattleshipsUtilityPanel(BattleShipsGameState gameState, BattleShipsInputUnit inputUnit){
		setBounds(0, 0, 600, 75);
		createButtons();
		addButtonsToPanel();
		
	}
	
	private void createButtons() {
		btnExit = new JButton("Exit Game");
		btnNew = new JButton("New Game");
		btnAdd = new JButton("Add Ship to game");
				
	}
	private void addButtonsToPanel() {
		add(btnNew);
		add(btnExit);
		add(btnAdd);
	}
	public JButton getBtnNew() {
		return btnNew;
	}
	public JButton getBtnExit() {
		return btnExit;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}

	

}
