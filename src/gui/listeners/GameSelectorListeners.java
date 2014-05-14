package gui.listeners;

import game.init.Runner;
import gui.GameSelectorPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import othellobackend.OthelloGameFacade;
import othellogui.OthelloGameFrame;
import othellogui.OthelloGuiIOFactory;
import othellogui.OthelloGuiInputUnit;
import othellogui.OthelloGuiOutputUnit;

public class GameSelectorListeners {
	private GameSelectorPanel gameSelectorPanel;

	public GameSelectorListeners (GameSelectorPanel gameSelectorPanel) {
		this.gameSelectorPanel = gameSelectorPanel;
	}
	
	public void addGameSelectorListeners() {
		gameSelectorPanel.getBtnGameOne().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { startOthelloGame(); }});
		gameSelectorPanel.getBtnGameTwo().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { startBattleShipsGame(); }});
	}
	
	private void startOthelloGame() {
		OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
		OthelloGuiOutputUnit outputUnit = new OthelloGuiOutputUnit(new OthelloGameFrame(inputUnit));
		new Runner(new OthelloGameFacade(), new OthelloGuiIOFactory(inputUnit, outputUnit)).run();
	}
	
	private void startBattleShipsGame() {
		
	}
}
