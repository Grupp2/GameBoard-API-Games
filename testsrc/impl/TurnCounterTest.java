package impl;

import game.impl.Player;
import impl.util.TurnCounter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TurnCounterTest {

    Player tmp;

    @Test
    public void test(){

        TurnCounter turnCounter = new TurnCounter(new ArrayList<Player>(){{
            add(tmp = new Player("player1", null));
            add(new Player("player2", null));
        }}, tmp);

        assertEquals("player1",turnCounter.getCurrentPlayer().getName());

        turnCounter.increment();
        assertEquals("player2",turnCounter.getCurrentPlayer().getName());
        assertEquals("player1",turnCounter.getLastPlayer().getName());

        turnCounter.increment();
        assertEquals("player1",turnCounter.getCurrentPlayer().getName());
        assertEquals("player2",turnCounter.getLastPlayer().getName());

        turnCounter = new TurnCounter(new ArrayList<Player>(){{
            add(tmp = new Player("player1", null));
            add(new Player("player2", null));
            add(new Player("player3", null));
        }}, tmp);


        assertEquals("player1",turnCounter.getCurrentPlayer().getName());
        assertEquals(null,turnCounter.getLastPlayer());

        turnCounter.increment();
        assertEquals("player2",turnCounter.getCurrentPlayer().getName());
        assertEquals("player1",turnCounter.getLastPlayer().getName());

        turnCounter.increment();
        assertEquals("player3",turnCounter.getCurrentPlayer().getName());
        assertEquals("player2",turnCounter.getLastPlayer().getName());

        turnCounter.increment();
        assertEquals("player1",turnCounter.getCurrentPlayer().getName());
        assertEquals("player3",turnCounter.getLastPlayer().getName());

    }
}
