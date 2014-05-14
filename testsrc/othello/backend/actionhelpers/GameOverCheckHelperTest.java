package othello.backend.actionhelpers;


import othello.backend.State;
import othello.backend.actionhelpers.GameOverCheckHelper;
import othello.backend.classhelpers.MoveHelper;
import othello.backend.classhelpers.PlayerHelper;
import game.impl.GamePiece;
import game.impl.Player;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameOverCheckHelperTest {
    @Test
    public void testIsBoardFull() throws Exception {
        State state = mock(State.class);
        PlayerHelper playerHelper = mock(PlayerHelper.class);
        MoveHelper moveHelper = mock(MoveHelper.class);

        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);

        when(playerHelper.getPlayerOne()).thenReturn(playerOne);
        when(playerHelper.getPlayerTwo()).thenReturn(playerTwo);

        when(playerOne.getPieces())
            .thenReturn(new ArrayList<GamePiece>())
            .thenReturn(new ArrayList<GamePiece>(){{
                for(int i = 0; i < 32; i++)
                    add(new GamePiece(""));
            }})
            .thenReturn(new ArrayList<GamePiece>() {{
                for (int i = 0; i < 64; i++)
                    add(new GamePiece(""));
            }});

        when(playerTwo.getPieces())
                .thenReturn(new ArrayList<GamePiece>())
                .thenReturn(new ArrayList<GamePiece>(){{
                    for(int i = 0; i < 32; i++)
                        add(new GamePiece(""));
                }})
                .thenReturn(new ArrayList<GamePiece>(){{}});


        GameOverCheckHelper gameOverHelper = new GameOverCheckHelper(state, moveHelper, playerHelper);

        assertFalse(gameOverHelper.isBoardFull());
        assertTrue(gameOverHelper.isBoardFull());
        assertTrue(gameOverHelper.isBoardFull());
    }

    @Test
    public void testDoesAnyPlayerNotHaveAnyPiecesLeft() throws Exception {
        State state = mock(State.class);
        PlayerHelper playerHelper = mock(PlayerHelper.class);
        MoveHelper moveHelper = mock(MoveHelper.class);

        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);

        when(playerHelper.getPlayerOne()).thenReturn(playerOne);
        when(playerHelper.getPlayerTwo()).thenReturn(playerTwo);

        when(playerOne.getPieces())
                .thenReturn(new ArrayList<GamePiece>())
                .thenReturn(new ArrayList<GamePiece>(){{
                    for(int i = 0; i < 1; i++)
                        add(new GamePiece(""));
                }})
                .thenReturn(new ArrayList<GamePiece>() {{
                    for (int i = 0; i < 1; i++)
                        add(new GamePiece(""));
                }});

        when(playerTwo.getPieces())
                .thenReturn(new ArrayList<GamePiece>(){{
                    for(int i = 0; i < 1; i++)
                        add(new GamePiece(""));
                }})
                .thenReturn(new ArrayList<GamePiece>(){{
                    for(int i = 0; i < 1; i++)
                        add(new GamePiece(""));
                }})
                .thenReturn(new ArrayList<GamePiece>());


        GameOverCheckHelper gameOverHelper = new GameOverCheckHelper(state, moveHelper, playerHelper);

        assertTrue(gameOverHelper.doesAnyPlayerNotHaveAnyPiecesLeft());
        assertFalse(gameOverHelper.doesAnyPlayerNotHaveAnyPiecesLeft());
        assertTrue(gameOverHelper.doesAnyPlayerNotHaveAnyPiecesLeft());
    }

    @Test
    public void testIsCurrentPlayerOutOfValidMoves() throws Exception {
        State state = mock(State.class);
        PlayerHelper playerHelper = mock(PlayerHelper.class);
        MoveHelper moveHelper = mock(MoveHelper.class);
        Player player = mock(Player.class);

        when(state.getCurrentPlayer()).thenReturn(player).thenReturn(player);

        when(moveHelper.doesPlayerHaveAnyValidMoves(player)).thenReturn(true).thenReturn(false);

        GameOverCheckHelper gameOverHelper = new GameOverCheckHelper(state, moveHelper, playerHelper);

        assertFalse(gameOverHelper.isCurrentPlayerOutOfValidMoves());
        assertTrue(gameOverHelper.isCurrentPlayerOutOfValidMoves());
    }
}
