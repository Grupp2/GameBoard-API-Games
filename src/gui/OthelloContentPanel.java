package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import game.api.GameState;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import backend.OthelloGameState;

public class OthelloContentPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GameState gameState;
	private JPanel contentPane;
	private JPanel gameBoardPanel;
	private OthelloStatusPanel statusPanel;
	private OthelloUtillityPanel utillityPanel;
	private OthelloGuiInputUnit inputUnit;
	private GameBoardListener gameBoardListener;
	private Color backgroundGreen = new Color(34, 177, 76, 255);

	public OthelloContentPanel(GameState gameState, OthelloGuiInputUnit inputUnit) {
		this.gameState = gameState;
		this.inputUnit = inputUnit;
		createGameBoardPanel();
		createUtillityPanel();
	}

	public JPanel getContentPane() {
		gameBoardListener = new GameBoardListener(gameBoardPanel, inputUnit);
		gameBoardListener.addButtonListeners();
		contentPane = new JPanel(new BorderLayout());
		createStatusPanel();
		populateTheLayout();
		this.validate();
		this.repaint();
		return contentPane;
	}
	
	public OthelloUtillityPanel getUtilityPanel() {
		return utillityPanel;
	}
	
	public JPanel getGameBoardPanel() {
		return this.gameBoardPanel;
	}
	
	public OthelloStatusPanel getStatusPanel() {
		return this.statusPanel;
	}

	private void createGameBoardPanel() {
		this.gameBoardPanel = new GameBoardPanel(gameState);
	}
	
	private void createUtillityPanel() {
		this.utillityPanel = new OthelloUtillityPanel((OthelloGameState)gameState, inputUnit);
	}
	
	private void createStatusPanel() {
		this.statusPanel = new OthelloStatusPanel();
		setStatusLabelProperties();
	}
	
	private void setStatusLabelProperties() {
		JLabel tmpLable = statusPanel.getPlayerInfoLabel();
		setLabelProperties(tmpLable);
		tmpLable = statusPanel.getStatusTextLabel();
		setLabelProperties(tmpLable);
	}

	private void setLabelProperties(JLabel tmpLable) {
		tmpLable.setBackground(backgroundGreen);
		tmpLable.setOpaque(true);
		tmpLable.setHorizontalAlignment(SwingConstants.CENTER);
		tmpLable.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}
	
	private void populateTheLayout() {
		contentPane.add(statusPanel, BorderLayout.PAGE_START);
		contentPane.add(gameBoardPanel, BorderLayout.CENTER);
		contentPane.add(utillityPanel, BorderLayout.PAGE_END);
	}
}