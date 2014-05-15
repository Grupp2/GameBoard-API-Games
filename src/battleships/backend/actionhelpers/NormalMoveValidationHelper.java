package battleships.backend.actionhelpers;

import game.impl.Move;

public class NormalMoveValidationHelper implements MoveValidatable {

	@Override
	public boolean makeMoveValidation(Move move) {
		return false;
	}

}
