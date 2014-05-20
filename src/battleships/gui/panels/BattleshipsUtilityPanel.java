package battleships.gui.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import battleships.backend.BattleShipsGameState;
import battleships.gui.BattleShipsInputUnit;
import battleships.gui.listeners.BattleshipsDeployListeners;

public class BattleshipsUtilityPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnNew;
	private JButton btnExit;
	
	public BattleshipsUtilityPanel(BattleShipsGameState gameState, BattleShipsInputUnit inpuUnit){
		setBounds(0, 0, 600, 75);
		createButtons();
		addButtonsToPanel();
		BattleshipsDeployListeners battleShipsDeployListeners = new BattleshipsDeployListeners(gameState, inpuUnit);
		battleShipsDeployListeners.createButtonListeners();
	}
	
	private void createButtons() {
		btnExit = new JButton("Exit Game");
		btnNew = new JButton("New Game");
				
	}
	private void addButtonsToPanel() {
		add(btnNew);
		add(btnExit);
	}
	public JButton getBtnNew() {
		return btnNew;
	}
	public JButton getBtnExit() {
		return btnExit;
	}

	

}
