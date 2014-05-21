package battleships.backend.actionhelpers;

import battleships.backend.Settings;
import battleships.backend.State;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;

import java.util.List;

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
        List<BoardLocation> boardLocations = state.getBoard().getLocations();
        BoardLocation locationToAlter = boardLocations.get(boardLocations.indexOf(move.getDestination()));

        switch (state.getMessage()) {
            case Settings.PIECE_SHIPHIT_MESSAGE:
                locationToAlter.setPiece(new GamePiece(Character.toString(Settings.PIECE_ALREADYHIT)));
                return true;
            case Settings.PIECE_MISS_MESSAGE:
                locationToAlter.setPiece(new GamePiece(Character.toString(Settings.PIECE_ALREADYHIT)));
                return true;
        }

        return false;
    }
}
