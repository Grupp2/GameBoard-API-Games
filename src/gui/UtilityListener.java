package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.api.GameState;
import backend.OthelloGameState;

public class UtilityListener {
	private OthelloUtillityPanel utilityPanel;
	private OthelloGameState gameState;
	private OthelloGuiInputUnit inputUnit;

	public UtilityListener(OthelloUtillityPanel utilityPanel,GameState gameState, OthelloGuiInputUnit inputUnit) {
		this.utilityPanel = utilityPanel;
		this.inputUnit = inputUnit;
		this.gameState = (OthelloGameState) gameState;
	}

	public void createButtonListeners() {
		utilityPanel.getBtnExit().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {exitGame();}});
		utilityPanel.getBtnNew().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {newGame();}});
		utilityPanel.getBtnLoad().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {loadGame();}});
		utilityPanel.getBtnSave().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {saveGame();}});
		utilityPanel.getBtnUndo().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {undoMove();}});
	}
	private void exitGame(){
		System.exit(0);
	}
	private void newGame(){
		gameState.reset();
		inputUnit.notifyListeners("republish");
	}
	private void loadGame(){
		
	}
	private void saveGame(){
		
	}
	
	private void undoMove(){
		if(gameState.canUndo()){
			gameState.undo();
			inputUnit.notifyListeners("republish");
		}
						
	}

}
