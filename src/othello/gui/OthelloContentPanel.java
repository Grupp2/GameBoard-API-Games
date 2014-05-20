package othello.gui;

import java.awt.*;

import othello.backend.OthelloGameFacade;
import game.api.GameState;
import othello.gui.listeners.GameBoardListener;
import othello.gui.panels.GameBoardPanel;

import javax.swing.*;

import othello.gui.panels.OthelloStatusPanel;
import othello.gui.panels.OthelloUtilityPanel;
import translator.CoordinateTranslator;
import translator.TranslatorAdapter;

public class OthelloContentPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private GameState gameState;

	private JPanel gameBoardPanel;
	private OthelloStatusPanel statusPanel;
	private OthelloUtilityPanel utilityPanel;

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
        this.utilityPanel = new OthelloUtilityPanel((OthelloGameFacade)gameState, inputUnit);
    }

    private void createStatusPanel() {
        this.statusPanel = new OthelloStatusPanel();
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