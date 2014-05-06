package gui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageResize {

	public BufferedImage resizeImage(BufferedImage image, int width, int height) {
		int type = 0;
		type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D graph = resizedImage.createGraphics();
		graph.drawImage(image, 0, 0, width, height, null);
		graph.dispose();
		return resizedImage;
	}

	public static void main (String[] s){
		GraphicsHolder gh = new GraphicsHolder();
		OthelloUtillityPanel ou = new OthelloUtillityPanel();
		JFrame frame = new JFrame();
		ImageResize ir = new ImageResize();
		frame.setContentPane(ou);
		
		frame.setVisible(true);
		ou.changeImage(ir.resizeImage(gh.getPlayer1Piece(),	 ou.readButtonMinSize(), ou.readButtonMinSize()));
	}


	}
	

