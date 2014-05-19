package battleships.backend.classhelpers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import game.impl.BoardLocation;

import org.junit.Before;
import org.junit.Test;

public class DeployPieceHelperTest {
	private DeployPieceCounter dpc;
	private DeployPieceHelper dph;
	
	@Before
	public void setUp() throws Exception {
		this.dpc = mock(DeployPieceCounter.class);
		this.dph = new DeployPieceHelper(dpc);
	}
	
	@Test
	public void deployPieceLenghtTwoTest() {
		when(dpc.getPiecesOfLengthTwo()).thenReturn(4);
		assertEquals(null, dph.deployPiece(new BoardLocation("A1")));
		assertEquals("", dph.deployPiece(new BoardLocation("A2")));
	}
	
	@Test
	public void deployPieceNoPieceLeftTest() {
		when(dpc.getPiecesOfLengthTwo()).thenReturn(0);
		assertEquals(null, dph.deployPiece(new BoardLocation("A1")));
		assertEquals("No pieces of the current size left to deploy!", dph.deployPiece(new BoardLocation("A2")));
	}
	
	@Test
	public void deployPieceLenghtFiveTest() {
		when(dpc.getPiecesOfLengthFive()).thenReturn(1);
		assertEquals(null, dph.deployPiece(new BoardLocation("H1")));
		assertEquals("", dph.deployPiece(new BoardLocation("D1")));
	}
	
	@Test
	public void deployPieceLenghtSixTest() {
		assertEquals(null, dph.deployPiece(new BoardLocation("H1")));
		assertEquals("No piece has the given length!", dph.deployPiece(new BoardLocation("C1")));
	}
	
	@Test
	public void deployPieceLenghtOneTest() {
		assertEquals(null, dph.deployPiece(new BoardLocation("H1")));
		assertEquals("No piece has the given length!", dph.deployPiece(new BoardLocation("H1")));
	}

	@Test
	public void diagonalPieceTest() {
		when(dpc.getPiecesOfLengthTwo()).thenReturn(4);
		assertEquals(null, dph.deployPiece(new BoardLocation("A1")));
		assertEquals("It is not legal to place a piece diagonally!", dph.deployPiece(new BoardLocation("B2")));
	}

}
