package backend.actionhelpers;

import backend.State;
import game.impl.GamePiece;
import game.impl.Player;

public class GamePieceHelper {

    private State state;

    public GamePieceHelper(State state){
        this.state = state;
    }

    public Player getOwnerOfPiece(GamePiece piece){
        if(state.getPlayers().get(0).hasPiece(piece))
            return state.getPlayers().get(0);

        return state.getPlayers().get(1);
    }

}
