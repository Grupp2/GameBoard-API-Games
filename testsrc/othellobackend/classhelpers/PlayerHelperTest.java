package othellobackend.classhelpers;

import othellobackend.Settings;
import othellobackend.State;
import game.impl.GamePiece;
import game.impl.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerHelperTest {
    State state;
    PlayerHelper playerHelper;

    @Before
    public void setUp() throws Exception {
        state = mock(State.class);
        playerHelper = new PlayerHelper(state);
    }

    @Test
    public void testGetPlayerScore() throws Exception {
        Player player = mock(Player.class);
        List<GamePiece> pieces = mock(List.class);

        when(player.getPieces()).thenReturn(pieces);

        when(pieces.size()).thenReturn(0, 15, 28);

        assertEquals(0, playerHelper.getPlayerScore(player));
        assertEquals(15, playerHelper.getPlayerScore(player));
        assertEquals(28, playerHelper.getPlayerScore(player));
    }

    @Test
    public void testGetPlayerOneAndTwo() throws Exception {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        List<Player> players = mock(List.class);

        when(state.getPlayers()).thenReturn(players);

        when(players.get(Settings.PLAYER_ONE_INDEX)).thenReturn(playerOne);
        when(players.get(Settings.PLAYER_TWO_INDEX)).thenReturn(playerTwo);

        assertEquals(playerOne, playerHelper.getPlayerOne());
        assertEquals(playerTwo, playerHelper.getPlayerTwo());
    }
}
