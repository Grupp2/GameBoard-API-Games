package backend;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import game.api.GameState;

import org.junit.Before;
import org.junit.Test;

public class TestCoordinateTranslator {

    GameState state;
    CoordinateTranslator translator;
    @Before
    public void setUp() throws Exception {
	state = mock(GameState.class);
	translator = new CoordinateTranslator(state);
    }

    @Test
    public void test() {
	if (!translator.translateFromGui("A1").equals("AA"))
	    fail("Incorrect translation");
    }

}
