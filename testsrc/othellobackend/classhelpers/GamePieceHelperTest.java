package othellobackend.classhelpers;

import othellobackend.State;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class GamePieceHelperTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetOwnerOfPiece() throws Exception {
        State state = mock(State.class);

        PlayerHelper playerHelper = mock(PlayerHelper.class);

        GamePieceHelper pieceHelper = new GamePieceHelper(state, playerHelper);

        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);

        GamePiece piece = mock(GamePiece.class);

        when(player1.hasPiece(piece)).thenReturn(true).thenReturn(false);

        when(playerHelper.getPlayerOne()).thenReturn(player1);
        when(playerHelper.getPlayerTwo()).thenReturn(player2);

        assertEquals(player1, pieceHelper.getOwnerOfPiece(piece));
        assertEquals(player2, pieceHelper.getOwnerOfPiece(piece));
    }

    @Test
    public void testChangeOwnerOfPiece() throws Exception {
        State state = mock(State.class);

        PlayerHelper playerHelper = mock(PlayerHelper.class);

        final GamePiece thePiece = mock(GamePiece.class);

        final BoardLocation locationOfPiece = new BoardLocation("test location");

        final Player currentOwner = mock(Player.class);
        final Player newOwner = mock(Player.class);

        locationOfPiece.setPiece(thePiece);

        List<GamePiece> currentOwnerPieces = new ArrayList<GamePiece>(){{
            add(thePiece);
        }};

        List<GamePiece> newOwnerPieces = new ArrayList<GamePiece>();

        GamePieceHelper pieceHelper = new GamePieceHelper(state, playerHelper){
            public Player getOwnerOfPiece(GamePiece piece){
                return currentOwner;
            }

            public BoardLocation getLocationOfPiece(GamePiece piece){
                return locationOfPiece;
            }
        };

        when(currentOwner.getPieces()).thenReturn(currentOwnerPieces);
        when(newOwner.getPieces()).thenReturn(newOwnerPieces);

        when(playerHelper.getPlayerOne()).thenReturn(currentOwner).thenReturn(currentOwner);
        when(playerHelper.getPlayerTwo()).thenReturn(newOwner);

        pieceHelper.changeOwnerOfPiece(thePiece);

        assertEquals(0, currentOwnerPieces.size());
        assertEquals(1, newOwnerPieces.size());
        assertNotEquals(thePiece, locationOfPiece.getPiece());
        assertTrue(locationOfPiece.getPiece() instanceof GamePiece);
    }

    @Test
    public void testGetLocationOfPiece() throws Exception {
        State state = mock(State.class);

        PlayerHelper playerHelper = mock(PlayerHelper.class);

        GamePieceHelper pieceHelper = new GamePieceHelper(state, playerHelper);

        GamePiece piece = mock(GamePiece.class);

        Board board = mock(Board.class);

        when(state.getBoard()).thenReturn(board);

        BoardLocation location = mock(BoardLocation.class);
        when(location.getPiece()).thenReturn(piece).thenReturn(piece);


        when(board.getLocations())
                .thenReturn(makeLocationMock1(location))
                .thenReturn(makeLocationMock2(location))
                .thenReturn(makeLocationMock3());

        assertEquals(location, pieceHelper.getLocationOfPiece(piece));
        assertEquals(location, pieceHelper.getLocationOfPiece(piece));
        assertEquals("Null location", pieceHelper.getLocationOfPiece(piece).getId());
    }

    public List<BoardLocation> makeLocationMock1(final BoardLocation locationMock){
        return new ArrayList<BoardLocation>(){{
            BoardLocation location1 = mock(BoardLocation.class);
            BoardLocation location2 = mock(BoardLocation.class);
            BoardLocation location3 = mock(BoardLocation.class);
            BoardLocation location4 = mock(BoardLocation.class);
            BoardLocation location5 = mock(BoardLocation.class);
            BoardLocation location6 = mock(BoardLocation.class);

            add(locationMock);
            add(location1);
            add(location2);
            add(location3);
            add(location4);
            add(location5);
            add(location6);
        }};
    }

    public List<BoardLocation> makeLocationMock2(final BoardLocation locationMock){
        return new ArrayList<BoardLocation>(){{
            BoardLocation location1 = mock(BoardLocation.class);
            BoardLocation location2 = mock(BoardLocation.class);
            BoardLocation location3 = mock(BoardLocation.class);
            BoardLocation location4 = mock(BoardLocation.class);
            BoardLocation location5 = mock(BoardLocation.class);
            BoardLocation location6 = mock(BoardLocation.class);

            add(location1);
            add(location2);
            add(location3);
            add(location4);
            add(location5);
            add(location6);
            add(locationMock);
        }};
    }

    public List<BoardLocation> makeLocationMock3(){
        return new ArrayList<BoardLocation>(){{
            BoardLocation location1 = mock(BoardLocation.class);
            BoardLocation location2 = mock(BoardLocation.class);
            BoardLocation location3 = mock(BoardLocation.class);
            BoardLocation location4 = mock(BoardLocation.class);
            BoardLocation location5 = mock(BoardLocation.class);
            BoardLocation location6 = mock(BoardLocation.class);

            add(location1);
            add(location2);
            add(location3);
            add(location4);
            add(location5);
            add(location6);
        }};
    }
}
