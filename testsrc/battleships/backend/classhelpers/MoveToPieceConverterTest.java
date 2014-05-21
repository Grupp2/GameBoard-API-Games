package battleships.backend.classhelpers;

import static org.junit.Assert.*;
import java.util.List;
import game.impl.BoardLocation;
import org.junit.Before;
import org.junit.Test;

public class MoveToPieceConverterTest {
	private MoveToPieceConverter mpc;

	@Before
	public void setUp() throws Exception {
		this.mpc = new MoveToPieceConverter();
	}

	@Test
	public void pieceLocationsColumnReverseTest() {
		List<BoardLocation> result = mpc.pieceLocations(new BoardLocation("A5"), new BoardLocation("A1"));
		assertEquals("A2", result.get(1).getId());
	}
	@Test
	public void pieceLocationsColumnTest() {
		List<BoardLocation> result = mpc.pieceLocations(new BoardLocation("A1"), new BoardLocation("A5"));
		assertEquals("A2", result.get(1).getId());
	}
	
	@Test
	public void pieceLocationsRowTest() {
		List<BoardLocation> result = mpc.pieceLocations(new BoardLocation("A1"), new BoardLocation("D1"));
		assertEquals("B1", result.get(1).getId());
	}

	@Test
	public void pieceLocationsRowReverseTest() {
		List<BoardLocation> result = mpc.pieceLocations(new BoardLocation("D1"), new BoardLocation("A1"));
		assertEquals("B1", result.get(1).getId());
	}
}
