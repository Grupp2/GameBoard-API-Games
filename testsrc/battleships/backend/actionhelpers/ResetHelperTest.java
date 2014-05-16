package battleships.backend.actionhelpers;

import battleships.Settings;
import battleships.backend.State;
import game.impl.BoardLocation;
import game.impl.Player;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ResetHelperTest {

    @Test
    public void createPlayers() throws Exception {
        State state = mock(State.class);

        ResetHelper helper = new ResetHelper(state);

        List<Player> players = helper.createPlayers();
        assertEquals(2, players.size());
        assertEquals(Settings.PLAYER_ONE_NAME, players.get(0).getName());
        assertEquals(Settings.PLAYER_TWO_NAME, players.get(1).getName());
    }

    @Test
    public void testResetBoard() throws Exception {
        State state = mock(State.class);

        ResetHelper helper = new ResetHelper(state);

        List<BoardLocation> locations = helper.createBoardLocations();

        assertEquals(200, locations.size());
        assertEquals("A1", locations.get(0).getId());
        assertEquals("A2", locations.get(1).getId());
        assertEquals("B1", locations.get(10).getId());
        assertEquals("T10", locations.get(199).getId());
    }
}
