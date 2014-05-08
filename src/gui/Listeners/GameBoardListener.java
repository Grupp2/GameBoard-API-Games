package gui.Listeners;

import gui.OthelloGuiInputUnit;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import translator.TextFileTranslator;
import translator.TranslatorAdapter;

public class GameBoardListener {
	private JButton currentButton;
	private OthelloGuiInputUnit inputUnit;
	private JPanel gameBoard;

	public GameBoardListener(JPanel gameBoard, OthelloGuiInputUnit inputUnit) {
		this.inputUnit = inputUnit;
		this.gameBoard = gameBoard;
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
		TranslatorAdapter ta = new TranslatorAdapter(new TextFileTranslator());
		inputUnit.notifyListeners(ta.translateFromUiToGameState(currentButton.getName()));
	}
}
