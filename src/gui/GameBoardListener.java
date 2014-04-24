package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoardListener {
	
	private String lastMove = "";

	public GameBoardListener(JPanel gameBoard) {
		for (Component ctrl : gameBoard.getComponents())
			if (ctrl instanceof JButton) {
				JButton btn = (JButton) ctrl;
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lastMove = e.getActionCommand();
					}
				});
			}
	}
	
	public String getLastMove() {
		return lastMove;
	}
}
