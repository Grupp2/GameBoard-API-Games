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
		utilityPanel.getBtnExit().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {System.exit(0);}});
		utilityPanel.getBtnNew().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {newGame();}});
		utilityPanel.getBtnLoad().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {System.exit(0);}});
		utilityPanel.getBtnSave().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {System.exit(0);}});
		utilityPanel.getBtnRedo().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {System.exit(0);}});
		utilityPanel.getBtnUndo().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {System.exit(0);}});
	}
	private void newGame(){
		gameState.reset();
		inputUnit.notifyListeners("republish");
	}

}
