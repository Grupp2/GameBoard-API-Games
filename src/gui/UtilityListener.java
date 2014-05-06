package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.api.GameState;
import backend.OthelloGameState;

public class UtilityListener {
	
	 private OthelloUtillityPanel utilityPanel;
	 private OthelloGameState gameState;
	 
	 public UtilityListener(OthelloUtillityPanel utilityPanel, GameState gameState){
		 this.utilityPanel = utilityPanel;
		 this.gameState = (OthelloGameState) gameState;
		 createButtonListeners();
	 }
	 
	 private void createButtonListeners(){
		 utilityPanel.getBtnExit().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);

				}
			});
	 }

}
