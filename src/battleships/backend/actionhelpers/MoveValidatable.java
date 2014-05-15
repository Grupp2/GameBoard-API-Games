package battleships.backend.actionhelpers;

import game.impl.Move;

public interface MoveValidatable {

	public boolean makeMoveValidation(Move move);
}
