package battleships.backend.actionhelpers;

import game.impl.Move;

public interface MoveValidateable {

	public boolean makeMoveValidation(Move move);
}
