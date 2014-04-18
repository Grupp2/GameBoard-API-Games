package impl;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import game.impl.Board;
import game.impl.Player;
import org.junit.Test;
import java.util.List;


public class OthelloGameFactoryTest {

    @Test
    public void testCreatePlayers(){
        OthelloGameFactory factory = new OthelloGameFactory();

        List<Player> players = factory.createPlayers();


        Player player1 = players.get(0);
        assertEquals(player1.getPieces().size(), 0);

       // for(int i = 0; i < 32; i++)
         //   assertEquals(player1.getPieces().get(i).getId(), "O");


        Player player2 = players.get(1);
        assertEquals(player2.getPieces().size(), 0);

      //  for(int i = 0; i < 32; i++)
          //  assertEquals(player2.getPieces().get(i).getId(), "X");
    }

    @Test
    public void testCreateBoard(){
        OthelloGameFactory factory = new OthelloGameFactory();

        Board gameBoard = factory.createBoard();

        assertEquals(64, gameBoard.getLocations().size());

        assertEquals("A1", gameBoard.getLocations().get(0).getId());
        assertEquals("A2", gameBoard.getLocations().get(1).getId());

        assertEquals("B1", gameBoard.getLocations().get(8).getId());
        assertEquals("B8", gameBoard.getLocations().get(15).getId());

        assertEquals("H8", gameBoard.getLocations().get(63).getId());
    }

}
