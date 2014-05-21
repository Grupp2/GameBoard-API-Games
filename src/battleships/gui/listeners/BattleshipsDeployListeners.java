package battleships.gui.listeners;

import game.api.GameState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import battleships.gui.BattleShipsInputUnit;
import battleships.gui.panels.BattleshipsUtilityPanel;

public class BattleshipsDeployListeners {
	private GameState gameState;
	private BattleShipsInputUnit inputUnit;
	private BattleshipsUtilityPanel utilityPanel;
	
	public BattleshipsDeployListeners(GameState gameState, BattleShipsInputUnit inputUnit){
		this.gameState = gameState;
		this.inputUnit = inputUnit;		
	}

	public void createButtonListeners() {
		utilityPanel.getBtnExit().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {exitGame();}});
		utilityPanel.getBtnNew().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {newGame();}});
		utilityPanel.getBtnAdd().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addShip();}});
	}		
	private void exitGame(){
		System.exit(0);
	}
	private void newGame(){
		gameState.reset();
		inputUnit.notifyListeners("republish");
	}
	private void addShip(){
		inputUnit.notifyListeners("");
	}

}
