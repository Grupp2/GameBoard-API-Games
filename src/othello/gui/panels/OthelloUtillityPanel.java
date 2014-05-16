package othello.gui.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import othello.backend.OthelloGameFacade;
import othello.gui.OthelloGuiInputUnit;
import othello.gui.listeners.OthelloUtilityListener;

public class OthelloUtillityPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnUndo;
	private JButton btnLoad;
	private JButton btnSave;
	private JButton btnNew;
	private JButton btnExit;

	public OthelloUtillityPanel(OthelloGameFacade gameState, OthelloGuiInputUnit inputUnit) {
		setBounds(0, 0, 600, 75);
		createButtons();
		addButtonsToPanel();
		OthelloUtilityListener othelloUtilityListener = new OthelloUtilityListener(this, gameState, inputUnit);
		othelloUtilityListener.createButtonListeners();
	}

	private void createButtons() {
		btnExit = new JButton("Exit Game");
		btnLoad = new JButton("Load Game");
		btnNew = new JButton("New Game");
		btnSave = new JButton("Save Game");
		btnUndo = new JButton("Undo Move");
	}

	private void addButtonsToPanel() {
		add(btnUndo);
		add(btnLoad);
		add(btnSave);
		add(btnNew);
		add(btnExit);
	}

	public JPanel getUtillityPanel() {
		return this;
	}
	
	public JButton getUndoButton() {
		return btnUndo;
	}

	public JButton getBtnLoad() {
		return btnLoad;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public JButton getBtnExit() {
		return btnExit;
	}
}