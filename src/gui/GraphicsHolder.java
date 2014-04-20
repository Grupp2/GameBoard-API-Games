package gui;

import java.awt.image.BufferedImage;

public class GraphicsHolder {

	private BufferedImage blankBoardPiece;
	private BufferedImage blankBoardPieceAlternate;
	private BufferedImage player1Piece;
	private BufferedImage player1PieceAlternate;
	private BufferedImage player1UndeployedPiece;
	private BufferedImage player2Piece;
	private BufferedImage player2PieceAlternate;
	private BufferedImage player2UndeployedPiece;
	
	public GraphicsHolder() {
		
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

	public BufferedImage getPlayer1PieceAlternate() {
		return player1PieceAlternate;
	}

	public BufferedImage getPlayer1UndeployedPiece() {
		return player1UndeployedPiece;
	}

	public BufferedImage getPlayer2Piece() {
		return player2Piece;
	}

	public BufferedImage getPlayer2PieceAlternate() {
		return player2PieceAlternate;
	}

	public BufferedImage getPlayer2UndeployedPiece() {
		return player2UndeployedPiece;
	}
}
