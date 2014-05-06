package gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GraphicsHolder {
	private BufferedImage blankBoardPiece;
	private BufferedImage blankBoardPieceAlternate;
	private BufferedImage player1Piece;
	private BufferedImage player1PieceAlternate;
	private BufferedImage player1UndeployedPiece;
	private BufferedImage player1UndeployedPieceAlternate;
	private BufferedImage player2Piece;
	private BufferedImage player2PieceAlternate;
	private BufferedImage player2UndeployedPiece;
	private BufferedImage player2UndeployedPieceAlternate;
	private ImageResize imageResizer = new ImageResize();
	
	public GraphicsHolder() {
		loadPictures();
	}

	private void loadPictures() {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("gui/Blank.jpg");
			blankBoardPiece = ImageIO.read(input);
			input = classLoader.getResourceAsStream("gui/svart.jpg");
			player1Piece = ImageIO.read(input);
			input = classLoader.getResourceAsStream("gui/svart_highlight.jpg");
			player1PieceAlternate = ImageIO.read(input);
			input = classLoader.getResourceAsStream("gui/vit.jpg");
			player2Piece = ImageIO.read(input);
			input = classLoader.getResourceAsStream("gui/vit_highlight.jpg");
			player2PieceAlternate = ImageIO.read(input);
		} catch (IOException e) {
			
		}
	}

	public BufferedImage getBlankBoardPiece() {
		return blankBoardPiece;
	}

	public BufferedImage getBlankBoardPieceAlternate() {
		return blankBoardPieceAlternate;
	}
	
	public BufferedImage getPlayer1Piece() {
		return player1Piece;
	}

	public BufferedImage getPlayer1Piece(Dimension dimension) {
		return imageResizer.resizeImage(player1Piece, dimension);
	}

	public BufferedImage getPlayer1PieceAlternate() {
		return player1PieceAlternate;
	}

	public BufferedImage getPlayer1UndeployedPiece() {
		return player1UndeployedPiece;
	}
	
	public BufferedImage getPlayer1UndeployedPieceAlternate() {
		return player1UndeployedPieceAlternate;
	}
	
	public BufferedImage getPlayer2Piece() {
		return player2Piece;
	}

	public BufferedImage getPlayer2Piece(Dimension dimension) {
		return imageResizer.resizeImage(player2Piece, dimension);
	}

	public BufferedImage getPlayer2PieceAlternate() {
		return player2PieceAlternate;
	}

	public BufferedImage getPlayer2UndeployedPiece() {
		return player2UndeployedPiece;
	}
	
	public BufferedImage getPlayer2UndeployedPieceAlternate() {
		return player2UndeployedPieceAlternate;
	}
}
