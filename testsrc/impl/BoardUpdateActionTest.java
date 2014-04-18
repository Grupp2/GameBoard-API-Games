package impl;

import game.api.GameState;
import game.impl.GamePiece;
import game.impl.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
public class BoardUpdateActionTest {



    @Test
    public void testExecute() throws Exception {

        GameState gameState = mock(GameState.class);

        Player player1 = new Player("player1", new ArrayList<GamePiece>(){{
            add(new GamePiece("O"));
            add(new GamePiece("O"));
        }});

        Player player2 = new Player("player2", new ArrayList<GamePiece>(){{
            add(new GamePiece("X"));
            add(new GamePiece("X"));
        }});



    }

}
