package backend;

import backend.undoableactions.UndoableAction;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UndoTest {


    @Test
    public void test(){
        State state = new State();
        state.setLastExecutedActionIndex(-1);
        state.setUndoableActionsStack(new ArrayList<UndoableAction>());

        UndoableAction action = mock(UndoableAction.class);

        state.pushActionOnUndoStack(action);

        assertEquals(0,state.getLastExecutedActionIndex());

        state.undo();

        assertEquals(-1,state.getLastExecutedActionIndex());

    }


}
