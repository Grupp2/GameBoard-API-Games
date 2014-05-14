package othellobackend.actionhelpers;

import othellobackend.State;
import othellobackend.classhelpers.BoardHelper;
import othellobackend.classhelpers.MoveHelper;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MoveValidationHelperTest {

    private State state;
    private MoveHelper moveHelper;
    private BoardHelper boardHelper;

    MoveValidationHelper moveValidationHelper;

    @Before
    public void setUp(){
        state = mock(State.class);
        moveHelper = mock(MoveHelper.class);
        boardHelper = mock(BoardHelper.class);

        moveValidationHelper = new MoveValidationHelper(state, moveHelper, boardHelper);
    }

    @Test
    public void testIsRequestForRepublish() throws Exception {
        assertTrue(moveValidationHelper.isRequestForRepublish(null));
        assertFalse(moveValidationHelper.isRequestForRepublish(new Move(new Player("", null), new BoardLocation(""), new BoardLocation(""))));
    }

    @Test
    public void testIsPlayersTurnToMove() throws Exception {
        Player player = mock(Player.class);
        Move move = mock(Move.class);

        when(state.getCurrentPlayer()).thenReturn(player).thenReturn(player);
        when(move.getPlayer()).thenReturn(player).thenReturn(null);

        assertTrue(moveValidationHelper.isPlayersTurnToMove(move));
        assertFalse(moveValidationHelper.isPlayersTurnToMove(move));
    }

    @Test
    public void testDoesDestinationExist() throws Exception {
        Move move = mock(Move.class);
        BoardLocation existingLocation = new BoardLocation("");
        when(move.getDestination()).thenReturn(null).thenReturn(existingLocation);
        when(boardHelper.doesLocationExistOnBoard(null)).thenReturn(false);
        when(boardHelper.doesLocationExistOnBoard(existingLocation)).thenReturn(true);

        assertFalse(moveValidationHelper.doesDestinationExist(move));
        assertTrue(moveValidationHelper.doesDestinationExist(move));
    }

    @Test
    public void testIsDestinationEmpty() throws Exception {
        Move move = mock(Move.class);

        BoardLocation location = mock(BoardLocation.class);

        when(location.getPiece()).thenReturn(new GamePiece("")).thenReturn(null);

        when(move.getDestination()).thenReturn(location).thenReturn(location);

        assertFalse(moveValidationHelper.isDestinationEmpty(move));
        assertTrue(moveValidationHelper.isDestinationEmpty(move));
    }

    @Test
    public void testIsTryingToMovePieceAlreadyPlaced() throws Exception {
        Move move = mock(Move.class);

        when(move.getSource()).thenReturn(new BoardLocation("")).thenReturn(null);

        assertTrue(moveValidationHelper.isTryingToMovePieceAlreadyPlaced(move));
        assertFalse(moveValidationHelper.isTryingToMovePieceAlreadyPlaced(move));
    }

    @Test
    public void testIsValidOthelloMove() throws Exception {
        Move move = mock(Move.class);
        Player player = mock(Player.class);
        BoardLocation location = mock(BoardLocation.class);

        when(moveHelper.isLocationValidOthelloMoveForPlayer(location, player)).thenReturn(true).thenReturn(false);

        assertTrue(moveValidationHelper.isValidOthelloMove(move));
        assertFalse(moveValidationHelper.isValidOthelloMove(move));
    }
}
