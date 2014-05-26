package battleships.backend.actionhelpers;

import game.impl.Move;

public interface MoveValidator {

	public boolean makeMoveValidation(Move move);
}
