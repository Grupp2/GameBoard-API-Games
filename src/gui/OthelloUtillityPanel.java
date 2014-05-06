package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OthelloUtillityPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnUndo;
	private JButton btnRedo;
	private JButton btnLoad;
	private JButton btnSave;
	private JButton btnNew;
	private JButton btnExit;

	public OthelloUtillityPanel() {
		setBounds(0, 0, 600, 75);
		createButtons();
		addButtonsToPanel();
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
}