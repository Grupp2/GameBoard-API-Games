package battleships.backend.actionhelpers;

import game.impl.Move;

public class NormalMoveHelper implements MoveExecutable {

	@Override
	public boolean executeMove(Move move, Move firstMove) {
		return false;
	}

}
