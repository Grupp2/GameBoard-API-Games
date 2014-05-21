package battleships.backend.actionhelpers;

import battleships.backend.State;
import game.impl.Move;

/**
 * Created by hugg on 2014-05-21.
 */
public class NormalMoveExecutor implements MoveExecutable {
    private State state;

    public NormalMoveExecutor(State state) {
        this.state = state;
    }
    @Override
    public boolean executeMove(Move move, Move firstMove) {
        //firstmove is only for deploymode
        //we only care about move here.

        return false;
    }
}
