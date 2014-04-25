package backend.actions;


import backend.State;
import backend.StateBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnIncrementTest{

    @Test
    public void test(){
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.buildDefault();

        State state = stateBuilder.getState();

        state.setCurrentPlayer(stateBuilder.getPlayer1());

        assertEquals(stateBuilder.getPlayer1(), state.getCurrentPlayer());
        assertEquals(null, state.getLastPlayer());

        new TurnIncrement(state).execute();
        assertEquals(stateBuilder.getPlayer1(), state.getLastPlayer());
        assertEquals(stateBuilder.getPlayer2(), state.getCurrentPlayer());

        new TurnIncrement(state).execute();
        assertEquals(stateBuilder.getPlayer1(), state.getCurrentPlayer());
        assertEquals(stateBuilder.getPlayer2(), state.getLastPlayer());

    }


}
