package impl;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

import game.impl.Board;
import game.impl.Player;

public class OthelloGameStateTest {


    @Test
    public void testReset(){
        OthelloGameState gameState = new OthelloGameState();



        gameState.reset();

        List<Player> players = gameState.getPlayers();

        Player player1 = players.get(0);
        assertEquals(player1.getPieces().size(), 32);

        for(int i = 0; i < 32; i++)
            assertEquals(player1.getPieces().get(i).getId(), "O");



        Player player2 = players.get(1);
        assertEquals(player2.getPieces().size(), 32);

        for(int i = 0; i < 32; i++)
            assertEquals(player2.getPieces().get(i).getId(), "X");


        Board gameBoard = gameState.getBoard();

        assertEquals("A1", gameBoard.getLocations().get(0).getId());
        assertEquals("A2", gameBoard.getLocations().get(1).getId());

        assertEquals("B1", gameBoard.getLocations().get(8).getId());
        assertEquals("B8", gameBoard.getLocations().get(15).getId());

        assertEquals("H8", gameBoard.getLocations().get(63).getId());
    }
}
