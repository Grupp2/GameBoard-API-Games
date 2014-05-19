package battleships.backend.classhelpers;

import static org.junit.Assert.*;
import game.impl.BoardLocation;

import org.junit.Before;
import org.junit.Test;

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
		dbh.checkPieceLocations(new BoardLocation("A1"), new BoardLocation("A2"), state);
		assertEquals("", dbh.checkPieceLocations(new BoardLocation("A1"), new BoardLocation("A2"), state));
	}

	private void resetState() {
		this.state = new State();
		ResetHelper rh = new ResetHelper(state);
		rh.reset();
	}

}
