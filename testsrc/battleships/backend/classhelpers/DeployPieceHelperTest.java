package battleships.backend.classhelpers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import game.impl.BoardLocation;
import org.junit.Before;
import org.junit.Test;
import battleships.backend.State;
import battleships.backend.actionhelpers.ResetHelper;

public class DeployPieceHelperTest {
	private DeployPieceCounter dpc;
	private DeployPieceHelper dph;
	private State state;
	
	@Before
	public void setUp() throws Exception {
		this.dpc = mock(DeployPieceCounter.class);
		this.dph = new DeployPieceHelper(dpc);
		resetState();
	}
	
	private void resetState() {
		this.state = new State();
		ResetHelper rh = new ResetHelper(state);
		rh.reset();
	}
	
	@Test
	public void deployPieceLenghtTwoTest() {
		when(dpc.getPiecesOfLengthTwo()).thenReturn(4);
		assertEquals("firstMoveOk", dph.deployPiece(new BoardLocation("A1"), state, dpc));
		assertEquals("", dph.deployPiece(new BoardLocation("A2"), state, dpc));
	}
	
	@Test
	public void deployPieceNoPieceLeftTest() {
		when(dpc.getPiecesOfLengthTwo()).thenReturn(0);
		assertEquals("firstMoveOk", dph.deployPiece(new BoardLocation("A1"), state, dpc));
		assertEquals("No pieces of the current size left to deploy!", dph.deployPiece(new BoardLocation("A2"), state, dpc));
	}
	
	@Test
	public void deployPieceLenghtFiveTest() {
		when(dpc.getPiecesOfLengthFive()).thenReturn(1);
		assertEquals("firstMoveOk", dph.deployPiece(new BoardLocation("H1"), state, dpc));
		assertEquals("", dph.deployPiece(new BoardLocation("D1"), state, dpc));
	}
	
	@Test
	public void deployPieceLenghtSixTest() {
		assertEquals("firstMoveOk", dph.deployPiece(new BoardLocation("H1"), state, dpc));
		assertEquals("No piece has the given length!", dph.deployPiece(new BoardLocation("C1"), state, dpc));
	}
	
	@Test
	public void deployPieceLenghtOneTest() {
		assertEquals("firstMoveOk", dph.deployPiece(new BoardLocation("H1"), state, dpc));
		assertEquals("No piece has the given length!", dph.deployPiece(new BoardLocation("H1"), state, dpc));
	}

	@Test
	public void diagonalPieceTest() {
		when(dpc.getPiecesOfLengthTwo()).thenReturn(4);
		assertEquals("firstMoveOk", dph.deployPiece(new BoardLocation("A1"), state, dpc));
		assertEquals("It is not legal to place a piece diagonally!", dph.deployPiece(new BoardLocation("B2"), state, dpc));
	}

}
