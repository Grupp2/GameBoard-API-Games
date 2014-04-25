package backend.actions;


import backend.State;
import backend.StateBuilder;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HasEndedControlTest {


    @Test
    public void test(){

        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.buildDefault();
        State state = stateBuilder.getState();

        boolean result = new HasEndedControl(state).execute();
        assertTrue(result);


        fillPieces(state.getPlayers());
        result = new HasEndedControl(state).execute();
        assertTrue(result);


    }


    private void fillPieces(List<Player> players){
        for(int i = 0; i < 63; i++)
            players.get(0).getPieces().add(new GamePiece(""));

        players.get(1).getPieces().add(new GamePiece(""));
    }

}
