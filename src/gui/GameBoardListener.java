package gui;

import game.api.GameState;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoardListener {
	private String lastMove = "";
	private GameState gameState;
	private GraphicsHolder gh;
	private JButton currentButton;

	public GameBoardListener(JPanel gameBoard, GameState gameState, GraphicsHolder gh) {
		this.gameState = gameState;
		this.gh = gh;
		for (Component ctrl : gameBoard.getComponents())
			if (ctrl instanceof JButton) {
				JButton btn = (JButton) ctrl;
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lastMove = e.getActionCommand();
						currentButton = (JButton) e.getSource();
						placeGamePiece();
					}
				});
			}
	}
	
	private void placeGamePiece() {
		if (gameState.getPlayerInTurn().getName().equals("P2"))
			currentButton.setIcon(new ImageIcon(gh.getPlayer2Piece()));
		else
			currentButton.setIcon(new ImageIcon(gh.getPlayer1Piece()));
	}
	
	public String getLastMove() {
		return lastMove;
	}
}
