package battleships.backend.classhelpers;

import static org.junit.Assert.*;
import java.util.List;
import game.impl.BoardLocation;
import org.junit.Before;
import org.junit.Test;

public class MoveToPieceConvertorTest {
	private MoveToPieceConvertor mpc;

	@Before
	public void setUp() throws Exception {
		this.mpc = new MoveToPieceConvertor();
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

}
