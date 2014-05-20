package battleships.backend.actionhelpers;

import game.impl.Move;

public class NormalMoveValidationHelper implements MoveValidateable {

	@Override
	public boolean makeMoveValidation(Move move) {
		return false;
	}

}
