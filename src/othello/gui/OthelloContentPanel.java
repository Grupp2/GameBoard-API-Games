package othello.gui;

import java.awt.*;

import othello.backend.OthelloGameFacade;
import game.api.GameState;
import gui.listeners.GameBoardListener;
import gui.panels.GameBoardPanel;

import javax.swing.*;

import othello.gui.panels.OthelloStatusPanel;
import othello.gui.panels.OthelloUtillityPanel;
import translator.CoordinateTranslator;
import translator.TranslatorAdapter;

public class OthelloContentPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private GameState gameState;

	private JPanel gameBoardPanel;
	private OthelloStatusPanel statusPanel;
	private OthelloUtillityPanel utilityPanel;

	private Color backgroundGreen = new Color(34, 177, 76, 255);
	private final int statusLabelFontSize = 15;
	private final int playerInfoLabelFontSize = 20;

	public OthelloContentPanel(GameState gameState, OthelloGuiInputUnit inputUnit) {
		this.gameState = gameState;
        createGuiPanel(inputUnit);
	}

	private void createGuiPanel(OthelloGuiInputUnit inputUnit) {
		TranslatorAdapter ta = new TranslatorAdapter(new CoordinateTranslator());

        createGameBoardPanel(ta);
		createUtilityPanel(inputUnit);
        createStatusPanel();

        new GameBoardListener(gameBoardPanel, inputUnit, ta).addButtonListeners();

		populateTheLayout();
	}

    private void createGameBoardPanel(TranslatorAdapter ta) {
        this.gameBoardPanel = new GameBoardPanel(gameState, ta);
    }

    private void createUtilityPanel(OthelloGuiInputUnit inputUnit) {
        this.utilityPanel = new OthelloUtillityPanel((OthelloGameFacade)gameState, inputUnit);
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
        setLayout(new BorderLayout());

        add(statusPanel, BorderLayout.PAGE_START);
        add(gameBoardPanel, BorderLayout.CENTER);
        add(utilityPanel, BorderLayout.PAGE_END);

        setPreferredSize(new Dimension(600, 600));
    }



    public void setTurnLabel(ImageIcon icon, String text){
        statusPanel.setTurnLabel(icon, text);
    }

    public void setMessageLabel(String text){
        statusPanel.setMessageLabel(text);
    }

    public void setMessageFont(Font font){
        statusPanel.setMessageFont(font);
    }

    public void setUndoButtonEnabled(boolean enabled){
        utilityPanel.getUndoButton().setEnabled(enabled);
    }

	public JPanel getGameBoardPanel() {
		return gameBoardPanel;
	}

	

	

}