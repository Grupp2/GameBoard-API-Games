package othellobackend.util;

import game.impl.Board;
import game.impl.BoardLocation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class BoardParserTest {

    Board gameBoard;
    BoardLocation location;

    @Before
    public void before(){
        gameBoard = mock(Board.class);

        when(gameBoard.getLocations()).thenReturn(new ArrayList<BoardLocation>(){{
            for(int j = (int)'A'; j <= (int)'H'; j++)
                for(int i = 1; i <= 8; i++){
                    if(j == 'C' && i == 4){
                        BoardLocation loc = new BoardLocation(""+(char)j+i);
                        location = loc;
                        add(loc);
                    }
                    else
                        add(new BoardLocation(""+(char)j+i));
                }

        }});

    }

    @Test
    public void testGetRow() throws Exception {
        assertEquals("C4", location.getId());

        BoardParser parser = new BoardParser(gameBoard, location);

        List<BoardLocation> row = parser.getRow();

        assertEquals(8, row.size());

        assertEquals("C1", row.get(0).getId());
        assertEquals("C2", row.get(1).getId());
        assertEquals("C3", row.get(2).getId());
        assertEquals("C4", row.get(3).getId());
        assertEquals("C5", row.get(4).getId());
        assertEquals("C6", row.get(5).getId());
        assertEquals("C7", row.get(6).getId());
        assertEquals("C8", row.get(7).getId());
    }

    @Test
    public void testGetColumn() throws Exception {
        assertEquals("C4", location.getId());

        BoardParser parser = new BoardParser(gameBoard, location);

        List<BoardLocation> column = parser.getColumn();

        assertEquals(8, column.size());

        assertEquals("A4", column.get(0).getId());
        assertEquals("B4", column.get(1).getId());
        assertEquals("C4", column.get(2).getId());
        assertEquals("D4", column.get(3).getId());
        assertEquals("E4", column.get(4).getId());
        assertEquals("F4", column.get(5).getId());
        assertEquals("G4", column.get(6).getId());
        assertEquals("H4", column.get(7).getId());
    }

    @Test
    public void testGetLeftToRightDiagonal() throws Exception {
        assertEquals("C4", location.getId());

        BoardParser parser = new BoardParser(gameBoard, location);

        List<BoardLocation> diagonal = parser.getLeftToRightDiagonal();

        assertEquals(7, diagonal.size());

        assertEquals("A2", diagonal.get(0).getId());
        assertEquals("B3", diagonal.get(1).getId());
        assertEquals("C4", diagonal.get(2).getId());
        assertEquals("D5", diagonal.get(3).getId());
        assertEquals("E6", diagonal.get(4).getId());
        assertEquals("F7", diagonal.get(5).getId());
        assertEquals("G8", diagonal.get(6).getId());

    }

    @Test
    public void testGetRightToLeftDiagonal() throws Exception {
        assertEquals("C4", location.getId());

        BoardParser parser = new BoardParser(gameBoard, location);

        List<BoardLocation> diagonal = parser.getRightToLeftDiagonal();

        assertEquals(6, diagonal.size());

        assertEquals("A6", diagonal.get(0).getId());
        assertEquals("B5", diagonal.get(1).getId());
        assertEquals("C4", diagonal.get(2).getId());
        assertEquals("D3", diagonal.get(3).getId());
        assertEquals("E2", diagonal.get(4).getId());
        assertEquals("F1", diagonal.get(5).getId());

    }
}
