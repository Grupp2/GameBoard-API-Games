package backend.actionhelpers;

import backend.State;
import backend.classhelpers.PlayerHelper;
import game.impl.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class WinnerCalculationHelperTest {
    State state;
    PlayerHelper playerHelper;

    WinnerCalculationHelper winnerHelper;

    @Before
    public void setUp() throws Exception {
        state = mock(State.class);
        playerHelper = mock(PlayerHelper.class);
        winnerHelper = new WinnerCalculationHelper(state, playerHelper);
    }

    @Test
    public void testMakeWinnerCalculation() throws Exception {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);


        when(playerHelper.getPlayerOne()).thenReturn(playerOne);
        when(playerHelper.getPlayerTwo()).thenReturn(playerTwo);

        when(playerHelper.getPlayerScore(playerOne)).thenReturn(10).thenReturn(5).thenReturn(0);
        when(playerHelper.getPlayerScore(playerTwo)).thenReturn(5).thenReturn(10).thenReturn(0);

        assertEquals(playerOne, winnerHelper.makeWinnerCalculation());
        assertEquals(playerTwo, winnerHelper.makeWinnerCalculation());
        assertEquals(null, winnerHelper.makeWinnerCalculation());
    }
}
