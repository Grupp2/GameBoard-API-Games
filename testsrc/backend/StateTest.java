package backend;

import backend.actions.Reset;
import game.impl.Player;
import org.junit.Test;

public class StateTest {

    @Test(expected = RuntimeException.class)
    public void testSetInvalidCurrentPlayer(){
        State state = new State();

        new Reset(state).execute();

        state.setCurrentPlayer(new Player("invalid", null));
    }

    @Test(expected = RuntimeException.class)
    public void testSetInvalidLastPlayer(){
        State state = new State();

        new Reset(state).execute();

        state.setLastPlayer(new Player("invalid", null));
    }
}
