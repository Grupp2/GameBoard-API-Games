package battleships.backend.actionhelpers;

import game.impl.Move;

public interface MoveExecutable {

	public boolean executeMove(Move move);
}
