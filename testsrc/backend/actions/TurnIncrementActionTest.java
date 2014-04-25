package backend.actions;


import backend.State;
import backend.StateBuilder;
import backend.undoableactions.TurnIncrementAction;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnIncrementActionTest {

    @Test
    public void test(){
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.buildDefault();

        State state = stateBuilder.getState();

        state.setCurrentPlayer(stateBuilder.getPlayer1());

        assertEquals(stateBuilder.getPlayer1(), state.getCurrentPlayer());
        assertEquals(null, state.getLastPlayer());

        TurnIncrementAction inc1 = new TurnIncrementAction(state);
        inc1.execute();
        assertEquals(stateBuilder.getPlayer1(), state.getLastPlayer());
        assertEquals(stateBuilder.getPlayer2(), state.getCurrentPlayer());


        TurnIncrementAction inc2 = new TurnIncrementAction(state);
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
