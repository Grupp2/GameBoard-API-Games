package othellogui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import othellobackend.OthelloGameFacade;
import othellogui.OthelloGuiInputUnit;
import game.api.GameState;
import gui.listeners.GameBoardListener;
import gui.panels.GameBoardPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import translator.CoordinateTranslator;
import translator.TranslatorAdapter;

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
	private final int statusLabelFontSize = 15;
	private final int playerInfoLabelFontSize = 20;

	public OthelloContentPanel(GameState gameState, OthelloGuiInputUnit inputUnit) {
		this.gameState = gameState;
		this.inputUnit = inputUnit;
	}

	public JPanel getContentPane() {
		TranslatorAdapter ta = new TranslatorAdapter(new CoordinateTranslator());
		createGameBoardPanel(ta);
		createUtillityPanel();
		gameBoardListener = new GameBoardListener(gameBoardPanel, inputUnit, ta);
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
		return gameBoardPanel;
	}
	
	public OthelloStatusPanel getStatusPanel() {
		return statusPanel;
	}

	private void createGameBoardPanel(TranslatorAdapter ta) {
		this.gameBoardPanel = new GameBoardPanel(gameState, ta);
	}
	
	private void createUtillityPanel() {
		this.utillityPanel = new OthelloUtillityPanel((OthelloGameFacade)gameState, inputUnit);
	}
	
	private void createStatusPanel() {
		this.statusPanel = new OthelloStatusPanel();
		setStatusLabelProperties();
	}
	
	private void setStatusLabelProperties() {
		JLabel tmpLable = statusPanel.getPlayerInfoLabel();
		setLabelProperties(tmpLable, playerInfoLabelFontSize);
		tmpLable = statusPanel.getStatusTextLabel();
		setLabelProperties(tmpLable, statusLabelFontSize);
	}

	private void setLabelProperties(JLabel tmpLable, int fontSize) {
		tmpLable.setBackground(backgroundGreen);
		tmpLable.setOpaque(true);
		tmpLable.setHorizontalAlignment(SwingConstants.CENTER);
		tmpLable.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
	}
	
	private void populateTheLayout() {
		contentPane.add(statusPanel, BorderLayout.PAGE_START);
		contentPane.add(gameBoardPanel, BorderLayout.CENTER);
		contentPane.add(utillityPanel, BorderLayout.PAGE_END);
	}
}