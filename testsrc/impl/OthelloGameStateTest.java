package impl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import game.impl.Board;
import game.impl.Player;
import game.api.GameState;

public class OthelloGameStateTest {

    private OthelloGameFactory createMockFactory(){
        OthelloGameFactory factory = mock(OthelloGameFactory.class);

        when(factory.createPlayers()).thenReturn(new ArrayList<Player>(){
            {
                add(new Player("player", null));
            }
        });

        when(factory.createBoard()).thenReturn(new Board(null));

        return factory;
    }

    @Test
    public void testReset(){
        /*
        GameState gameState = new OthelloGameState(createMockFactory());

        List<Player> players = gameState.getPlayers();
        assertEquals(1, players.size());
        assertEquals("player", players.get(0).getName());

        Board board = gameState.getBoard();
        assertNull(board.getLocations());

        assertEquals("", gameState.getMessage());*/

    }
}
