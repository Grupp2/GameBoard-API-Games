package gui;

import game.io.InputUnit;

import javax.swing.JButton;
import javax.swing.JPanel;

import backend.OthelloGameState;

public class OthelloUtillityPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnUndo;
	private JButton btnRedo;
	private JButton btnLoad;
	private JButton btnSave;
	private JButton btnNew;
	private JButton btnExit;

	public OthelloUtillityPanel(OthelloGameState gameState, OthelloGuiInputUnit inputUnit) {
		setBounds(0, 0, 600, 75);
		createButtons();
		addButtonsToPanel();
		UtilityListener utilityListener = new UtilityListener(this, gameState, inputUnit);
	}

	private void createButtons() {
		btnExit = new JButton("Exit Game");
		btnLoad = new JButton("Load Game");
		btnNew = new JButton("New Game");
		btnRedo = new JButton("Redo Move");
		btnSave = new JButton("Save Game");
		btnUndo = new JButton("Undo Move");
	}

	private void addButtonsToPanel() {
		add(btnUndo);
		add(btnRedo);
		add(btnLoad);
		add(btnSave);
		add(btnNew);
		add(btnExit);
	}

	public JPanel getUtillityPanel() {
		return this;
	}
	
	public JButton getBtnUndo() {
		return btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
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