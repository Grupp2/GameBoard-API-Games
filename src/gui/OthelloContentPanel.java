package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import game.api.GameState;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OthelloContentPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GameState gameState;
	private JPanel contentPane;
	private JPanel gameBoardPanel;
	private JPanel utillityPanel;
	private JLabel lblStatusText;
	private OthelloGuiInputUnit inputUnit;
	private GameBoardListener gameBoardListener;

	public OthelloContentPanel(GameState gameState, OthelloGuiInputUnit inputUnit) {
		this.gameState = gameState;
		this.inputUnit = inputUnit;
		createGameBoardPanel();
		createUtillityPanel();
	}

	public JPanel getContentPane() {
		gameBoardListener = new GameBoardListener(gameBoardPanel, inputUnit);
		contentPane = new JPanel(new BorderLayout());
		createStatusLabel();
		populateTheLayout();
		this.validate();
		this.repaint();
		return contentPane;
	}
	
	public JPanel getGameBoardPanel() {
		return this.gameBoardPanel;
	}
	
	public JLabel getStatusTextLabel() {
		return this.lblStatusText;
	}

	private void createGameBoardPanel() {
		this.gameBoardPanel = new GameBoardPanel(gameState);
	}
	
	private void createUtillityPanel() {
		this.utillityPanel = new OthelloUtillityPanel();
	}
	
	private void createStatusLabel() {
		lblStatusText = new JLabel();
		lblStatusText.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusText.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}
	
	private void populateTheLayout() {
		contentPane.add(lblStatusText, BorderLayout.PAGE_START);
		contentPane.add(gameBoardPanel, BorderLayout.CENTER);
		contentPane.add(utillityPanel, BorderLayout.PAGE_END);
	}
}