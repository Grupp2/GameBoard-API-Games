package othellobackend.classhelpers;

import othellobackend.State;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BoardHelperTest {

    @Test
    public void testGetLocationById() throws Exception {

        State state = mock(State.class);

        Board board = mock(Board.class);

        when(board.getLocations()).thenReturn(new ArrayList<BoardLocation>(){{
            add(new BoardLocation("TEST1"));
            add(new BoardLocation("TEST2"));
            add(new BoardLocation("TEST3"));
            add(new BoardLocation("TEST4"));
            add(new BoardLocation("TEST5"));
            add(new BoardLocation("TEST6"));
            add(new BoardLocation("TEST7"));
        }});

        when(state.getBoard()).thenReturn(board);

        BoardHelper boardHelper = new BoardHelper(state);

        assertEquals("TEST4", boardHelper.getLocationById("TEST4").getId());
        assertEquals("TEST7", boardHelper.getLocationById("TEST7").getId());
        assertEquals("TEST1", boardHelper.getLocationById("TEST1").getId());

        assertEquals(null, boardHelper.getLocationById("NON EXISTING"));
    }

    @Test
    public void testIsLocationEmpty() throws Exception {
        State state = mock(State.class);
        BoardHelper boardHelper = new BoardHelper(state);

        BoardLocation location = new BoardLocation("Test location");

        assertTrue(boardHelper.isLocationEmpty(location));

        location.setPiece(new GamePiece("Test Piece"));
        assertFalse(boardHelper.isLocationEmpty(location));

        location.setPiece(null);
        assertTrue(boardHelper.isLocationEmpty(location));
    }

    @Test
    public void testEmptyLocation() throws Exception {
        State state = mock(State.class);
        BoardHelper boardHelper = new BoardHelper(state);

        BoardLocation location = new BoardLocation("Test location");
        location.setPiece(new GamePiece("Test Piece"));

        boardHelper.emptyLocation(location);
        assertTrue(boardHelper.isLocationEmpty(location));

    }

    @Test
    public void testDoesLocationExistOnBoard() throws Exception{
        State state = mock(State.class);
        Board board = mock(Board.class);
        final BoardLocation theLocation = mock(BoardLocation.class);

        ArrayList<BoardLocation> existingList = new ArrayList<BoardLocation>(){
            {
                add(theLocation);
            }
        };

        ArrayList<BoardLocation> nonExistingList = new ArrayList<BoardLocation>();


        when(state.getBoard()).thenReturn(board).thenReturn(board);

        when(board.getLocations()).thenReturn(existingList).thenReturn(nonExistingList);


        BoardHelper boardHelper = new BoardHelper(state);

        assertTrue(boardHelper.doesLocationExistOnBoard(theLocation));
        assertFalse(boardHelper.doesLocationExistOnBoard(theLocation));
    }
}
