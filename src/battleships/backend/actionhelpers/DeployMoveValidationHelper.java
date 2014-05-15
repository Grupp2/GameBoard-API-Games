package battleships.backend.actionhelpers;

import game.impl.Move;

public class DeployMoveValidationHelper implements MoveValidatable {

	@Override
	public boolean makeMoveValidation(Move move) {
		return false;
	}

}
