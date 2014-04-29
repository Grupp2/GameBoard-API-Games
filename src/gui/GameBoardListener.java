package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoardListener {
	private JButton currentButton;
	private OthelloGuiInputUnit inputUnit;

	public GameBoardListener(JPanel gameBoard, OthelloGuiInputUnit inputUnit) {
		this.inputUnit = inputUnit;
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
		inputUnit.notifyListeners(currentButton.getName());
	}
}
