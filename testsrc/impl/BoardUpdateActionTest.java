package impl;

import game.api.GameState;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
public class BoardUpdateActionTest {

    GameState gameState;
    BoardParser boardParser;

    GamePiece piece1, piece2, piece3, piece4, newPiece;

    @Before
    public void before(){
        gameState = mock(GameState.class);

        final Player player1 = new Player("player1", new ArrayList<GamePiece>(){{
            add(piece1 = new GamePiece("O"));
            add(piece2 = new GamePiece("O"));
        }});

        final Player player2 = new Player("player2", new ArrayList<GamePiece>(){{
            add(piece3 = new GamePiece("X"));
            add(piece4 = new GamePiece("X"));
        }});

        when(gameState.getPlayers()).thenReturn(new ArrayList<Player>(){{
            add(player1);
            add(player2);
        }});


        boardParser = mock(BoardParser.class);

        when(boardParser.getRow()).thenReturn(
            new ArrayList<BoardLocation>(){{

            }}
        );

    }

    @Test
    public void testExecute() throws Exception {


    }

}
