package gui.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import othello.gui.OthelloGuiInputUnit;
import translator.TranslatorAdapter;

public class GameBoardListener {
	private JButton currentButton;
	private OthelloGuiInputUnit inputUnit;
	private JPanel gameBoard;
	private TranslatorAdapter ta;

	public GameBoardListener(JPanel gameBoard, OthelloGuiInputUnit inputUnit, TranslatorAdapter ta) {
		this.inputUnit = inputUnit;
		this.gameBoard = gameBoard;
		this.ta = ta;
	}
	
	public void addButtonListeners() {
		for (Component ctrl : gameBoard.getComponents())
			if (ctrl instanceof JButton) {
				JButton btn = (JButton) ctrl;
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentButton = (JButton) e.getSource();
						createMove();
					}
				});
			}
	}
	
	private void createMove() {
		inputUnit.notifyListeners(ta.translateFromUiToGameState(currentButton.getName()));
	}
}
