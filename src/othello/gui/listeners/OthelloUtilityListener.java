package othello.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import othello.backend.OthelloGameFacade;
import othello.gui.OthelloGuiInputUnit;
import othello.gui.panels.OthelloUtillityPanel;
import game.api.GameState;

public class OthelloUtilityListener {
	private othello.gui.panels.OthelloUtillityPanel utilityPanel;
	private OthelloGameFacade gameState;
	private OthelloGuiInputUnit inputUnit;

	public OthelloUtilityListener(OthelloUtillityPanel utilityPanel, GameState gameState, OthelloGuiInputUnit inputUnit) {
		this.utilityPanel = utilityPanel;
		this.inputUnit = inputUnit;
		this.gameState = (OthelloGameFacade) gameState;
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
