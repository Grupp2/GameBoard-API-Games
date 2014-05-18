package gui;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameSelectorPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnGameOne;
	private JButton btnGameTwo;
	private final int gridRows = 2;
	private final int gridColumns = 1;
	
	public GameSelectorPanel() {
		this.btnGameOne = new JButton();
		this.btnGameTwo = new JButton("BattleShips Game");
		createPanel();
	}
	
	private void createPanel() {
		setLayout(new GridLayout(gridRows, gridColumns));
		addPictureToButtonOne();
		add(btnGameOne);
		add(btnGameTwo);
	}
	
	private void addPictureToButtonOne() {
		try {
			BufferedImage btnImg;
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("gui/graphics/Othello_btn_img.jpg");
			btnImg = ImageIO.read(input);
			btnGameOne.setIcon(new ImageIcon(btnImg));
		} catch (IOException e) {
			
		}
	}
	
	public GameSelectorPanel getPanel() {
		return this;
	}
	
	public JButton getBtnGameOne() {
		return btnGameOne;
	}

	public JButton getBtnGameTwo() {
		return btnGameTwo;
	}

}
