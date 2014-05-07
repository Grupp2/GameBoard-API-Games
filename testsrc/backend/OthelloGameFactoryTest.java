package backend;

import static org.junit.Assert.assertEquals;

import game.impl.Board;
import game.impl.Player;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


public class OthelloGameFactoryTest {

    OthelloGameFactory factory;

    @Before
    public void setUp(){
        factory = new OthelloGameFactory();
    }

    @Test
    public void testCreatePlayers(){
        List<Player> players = factory.createPlayers();

        Player player1 = players.get(0);
        assertEquals(player1.getPieces().size(), 0);

        Player player2 = players.get(1);
        assertEquals(player2.getPieces().size(), 0);
    }

    @Test
    public void testCreateBoard(){

        Board gameBoard = factory.createBoard();

        assertEquals(64, gameBoard.getLocations().size());

        assertEquals("A1", gameBoard.getLocations().get(0).getId());
        assertEquals("A2", gameBoard.getLocations().get(1).getId());

        assertEquals("B1", gameBoard.getLocations().get(8).getId());
        assertEquals("B8", gameBoard.getLocations().get(15).getId());

        assertEquals("H8", gameBoard.getLocations().get(63).getId());
    }

    @Test
    public void testCreateUndoableActionStack(){
        assertEquals(0, factory.createUndoableActionStack().size());
    }

    @Test
    public void testCreateLastExecutedActionIndex(){
        assertEquals(OthelloGameFactory.DEFAULT_ACTION_INDEX, factory.createLastExecutedActionIndex());
    }

    @Test
    public void testCreateStateMessage(){
        assertEquals(OthelloGameFactory.DEFAULT_MESSAGE, factory.createStateMessage());
    }

    @Test
    public void testCreatePlayerOnePiece(){
        assertEquals(Settings.PLAYER_ONE_PIECE_ID, factory.createPlayerOnePiece().getId());
    }

    @Test
    public void testCreatePlayerTwoPiece(){
        assertEquals(Settings.PLAYER_TWO_PIECE_ID, factory.createPlayerTwoPiece().getId());
    }
}
