package battleships.backend.actionhelpers;

import static org.junit.Assert.*;
import game.impl.GamePiece;
import game.impl.Move;

import org.junit.Before;
import org.junit.Test;

import battleships.backend.State;

public class DeployMoveValidationHelperTest {
	private DeployMoveValidationHelper dmvh;
	private State state;
	
	@Before
	public void setUp() throws Exception {
		this.state = new State();
		ResetHelper rs = new ResetHelper(state);
		rs.reset();
		this.dmvh = new DeployMoveValidationHelper(state);
	}

	@Test
	public void test() {
		//dmvh.makeMoveValidation(new Move(state.getPlayerInTurn(), new GamePiece(id), destination));
		//fail("Not yet implemented");
	}

}
