package backend.actions;

import backend.State;
import org.junit.Test;

import static org.junit.Assert.*;


public class ResetTest{

    @Test
    public void test(){
        State state = new State();

        new Reset(state).execute();

        assertEquals(state.getPlayers().get(0), state.getCurrentPlayer());
        assertEquals(null, state.getLastPlayer());

        assertEquals(2, state.getPlayers().get(0).getPieces().size());
        assertEquals(2, state.getPlayers().get(0).getPieces().size());
    }


}
