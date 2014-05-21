package battleships.backend.actionhelpers;

import game.impl.Move;

public interface MoveExecutable {

	public void executeMove(Move move, Move firstMove);
}
