package backend.actions;


import backend.State;
import backend.StateBuilder;
import backend.undoableactions.TurnIncrement;
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

        TurnIncrement inc1 = new TurnIncrement(state);
        inc1.execute();
        assertEquals(stateBuilder.getPlayer1(), state.getLastPlayer());
        assertEquals(stateBuilder.getPlayer2(), state.getCurrentPlayer());


        TurnIncrement inc2 = new TurnIncrement(state);
        inc2.execute();
        assertEquals(stateBuilder.getPlayer1(), state.getCurrentPlayer());
        assertEquals(stateBuilder.getPlayer2(), state.getLastPlayer());


        inc2.undo();
        assertEquals(stateBuilder.getPlayer1(), state.getLastPlayer());
        assertEquals(stateBuilder.getPlayer2(), state.getCurrentPlayer());

        inc1.undo();
        assertEquals(stateBuilder.getPlayer1(), state.getCurrentPlayer());
        assertEquals(null, state.getLastPlayer());
    }


}
