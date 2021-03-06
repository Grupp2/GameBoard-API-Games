package client;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameSelectionPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnGameOne;
	private JButton btnGameTwo;
	private final int gridRows = 2;
	private final int gridColumns = 1;
	
	public GameSelectionPanel() {
		this.btnGameOne = new JButton();
		this.btnGameTwo = new JButton();
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
			InputStream input = classLoader.getResourceAsStream("client/Othello_btn_img.jpg");
			btnImg = ImageIO.read(input);
			btnGameOne.setIcon(new ImageIcon(btnImg));
			input = classLoader.getResourceAsStream("client/BattleShips_btn_img.jpg");
			btnImg = ImageIO.read(input);
			btnGameTwo.setIcon(new ImageIcon(btnImg));
		} catch (IOException e) {
			
		}
	}
	
	public GameSelectionPanel getPanel() {
		return this;
	}
	
	public JButton getBtnGameOne() {
		return btnGameOne;
	}

	public JButton getBtnGameTwo() {
		return btnGameTwo;
	}

}
