package othello.backend.actionhelpers;

import othello.backend.OthelloGameFactory;
import othello.backend.Settings;
import othello.backend.State;
import othello.backend.actionhelpers.ResetHelper;
import othello.backend.classhelpers.BoardHelper;
import othello.backend.classhelpers.PlayerHelper;
import othello.backend.undoableactions.UndoableAction;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ResetHelperTest {
    private State state;
    private OthelloGameFactory factory;
    private BoardHelper boardHelper;
    private PlayerHelper playerHelper;

    ResetHelper resetHelper;

    @Before
    public void setUp(){
        state = mock(State.class);
        factory = mock(OthelloGameFactory.class);
        boardHelper = mock(BoardHelper.class);
        playerHelper = mock(PlayerHelper.class);

        resetHelper = new ResetHelper(state, factory, boardHelper, playerHelper);
    }

    @Test
    public void testResetPlayers() throws Exception {
        List<Player> players = mock(List.class);

        when(factory.createPlayers()).thenReturn(players);

        resetHelper.resetPlayers();

        verify(state).setPlayers(players);
    }

    @Test
    public void testResetTurn() throws Exception {
        Player player = mock(Player.class);

        when(playerHelper.getPlayerOne()).thenReturn(player);

        resetHelper.resetTurn();

        verify(state).setCurrentPlayer(player);
        verify(state).setLastPlayer(null);
    }

    @Test
    public void testResetBoard() throws Exception {
        Board board = mock(Board.class);

        when(factory.createBoard()).thenReturn(board);

        resetHelper.resetBoard();

        verify(state).setBoard(board);
    }

    @Test
    public void testResetActionsStack() throws Exception {
        List<UndoableAction> actionStack = mock(List.class);

        when(factory.createUndoableActionStack()).thenReturn(actionStack);
        when(factory.createLastExecutedActionIndex()).thenReturn(123);

        resetHelper.resetActionsStack();

        verify(state).setUndoableActionsStack(actionStack);
        verify(state).setLastExecutedActionIndex(123);
    }

    @Test
    public void testResetMessage() throws Exception {
        when(factory.createStateMessage()).thenReturn("teststring");

        resetHelper.resetMessage();

        verify(state).setMessage("teststring");
    }

    @Test
    public void testSetStartingPositions() throws Exception {

        GamePiece playerOnePiece1 = mock(GamePiece.class);
        GamePiece playerOnePiece2 = mock(GamePiece.class);
        GamePiece playerTwoPiece1 = mock(GamePiece.class);
        GamePiece playerTwoPiece2 = mock(GamePiece.class);

        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);

        List<GamePiece> playerOnePieces = mock(List.class);
        List<GamePiece> playerTwoPieces = mock(List.class);

        BoardLocation playerOneStartLocation1 = mock(BoardLocation.class);
        BoardLocation playerOneStartLocation2 = mock(BoardLocation.class);
        BoardLocation playerTwoStartLocation1 = mock(BoardLocation.class);
        BoardLocation playerTwoStartLocation2 = mock(BoardLocation.class);


        when(factory.createPlayerOnePiece()).thenReturn(playerOnePiece1).thenReturn(playerOnePiece2);
        when(factory.createPlayerTwoPiece()).thenReturn(playerTwoPiece1).thenReturn(playerTwoPiece2);

        when(playerHelper.getPlayerOne()).thenReturn(playerOne);
        when(playerHelper.getPlayerTwo()).thenReturn(playerTwo);

        when(playerOne.getPieces()).thenReturn(playerOnePieces);
        when(playerTwo.getPieces()).thenReturn(playerTwoPieces);

        when(boardHelper.getLocationById(Settings.PLAYER_ONE_START_POSITION_1)).thenReturn(playerOneStartLocation1);
        when(boardHelper.getLocationById(Settings.PLAYER_ONE_START_POSITION_2)).thenReturn(playerOneStartLocation2);
        when(boardHelper.getLocationById(Settings.PLAYER_TWO_START_POSITION_1)).thenReturn(playerTwoStartLocation1);
        when(boardHelper.getLocationById(Settings.PLAYER_TWO_START_POSITION_2)).thenReturn(playerTwoStartLocation2);


        resetHelper.setStartingPositions();

        verify(playerOnePieces).add(playerOnePiece1);
        verify(playerOnePieces).add(playerOnePiece2);
        verify(playerTwoPieces).add(playerTwoPiece1);
        verify(playerTwoPieces).add(playerTwoPiece2);

        verify(playerOneStartLocation1).setPiece(playerOnePiece1);
        verify(playerOneStartLocation2).setPiece(playerOnePiece2);
        verify(playerTwoStartLocation1).setPiece(playerTwoPiece1);
        verify(playerTwoStartLocation2).setPiece(playerTwoPiece2);
    }
}
