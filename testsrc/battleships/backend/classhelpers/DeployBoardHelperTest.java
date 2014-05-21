package battleships.backend.classhelpers;

import static org.junit.Assert.*;

import java.util.List;

import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;

import org.junit.Before;
import org.junit.Test;

import battleships.backend.Settings;
import battleships.backend.State;
import battleships.backend.actionhelpers.ResetHelper;

public class DeployBoardHelperTest {
	private State state;
	private DeployBoardHelper dbh;

	@Before
	public void setUp() throws Exception {
		this.dbh = new DeployBoardHelper();
	}

	@Test
	public void checkEmptyLocationsTest() {
		resetState();
		assertEquals("", dbh.checkPieceLocations(new BoardLocation("A1"), new BoardLocation("A2"), state));
	}
	
	@Test
	public void checkOccupiedLocationsTest() {
		resetState();
		BoardLocation locationToAlter = getLocationById(state.getBoard(), "A2");
		locationToAlter.setPiece(new GamePiece(Settings.PIECE_SHIP));
		assertEquals("Pieces are overlapping!", dbh.checkPieceLocations(new BoardLocation("A1"), new BoardLocation("A2"), state));
	}

	private void resetState() {
		this.state = new State();
		ResetHelper rh = new ResetHelper(state);
		rh.reset();
	}
	
	private BoardLocation getLocationById(Board board, String id) {
        List<BoardLocation> locations = board.getLocations();
        for (int i = 0; i < locations.size(); i++)
            if (locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }

}
