package gui.graphics;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GraphicsHolder {
	private BufferedImage player1Piece;
	private BufferedImage player2Piece;
	private ImageResize imageResizer = new ImageResize();
	
	public GraphicsHolder() {
		loadPictures();
	}

	private void loadPictures() {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("gui/graphics/svart.jpg");
			player1Piece = ImageIO.read(input);
			input = classLoader.getResourceAsStream("gui/graphics/vit.jpg");
			player2Piece = ImageIO.read(input);
		} catch (IOException e) {
			
		}
	}

	public BufferedImage getPlayer1Piece() {
		return player1Piece;
	}

	public BufferedImage getPlayer1Piece(Dimension dimension) {
		return imageResizer.resizeImage(player1Piece, dimension);
	}

	public BufferedImage getPlayer2Piece() {
		return player2Piece;
	}

	public BufferedImage getPlayer2Piece(Dimension dimension) {
		return imageResizer.resizeImage(player2Piece, dimension);
	}
}
