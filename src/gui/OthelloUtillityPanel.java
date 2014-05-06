package gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
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

	public void changeImage(BufferedImage bImage) {
		btnUndo.setIcon(new ImageIcon(bImage));
	}

	public int readButtonMinSize() {
		int result = 0;
		Dimension d = btnUndo.getSize();
		result = d.height;
		if (d.width < result)
			result = d.width;

		return result;

	}

	public JPanel getUtillityPanel() {
		return this;
	}
}