package othello.backend.undoableactions;

import othello.backend.State;
import othello.backend.classhelpers.MoveHelper;
import game.impl.Player;
import java.util.List;

public class TurnIncrementAction implements UndoableAction{
    private State state;
    private Player oldCurrentPlayer;
    private Player oldLastPlayer;
//    private String oldMessage;

    public TurnIncrementAction(State state){
        this.state = state;
    }

    public void execute(){
        oldCurrentPlayer = state.getCurrentPlayer();
        oldLastPlayer = state.getLastPlayer();
//        oldMessage = state.getMessage();
        if (!isLastPlayerSet()) {
            List<Player> players = state.getPlayers();
            if (players.indexOf(state.getCurrentPlayer()) == 0)
                state.setLastPlayer(players.get(1));
            else
                state.setLastPlayer(players.get(0));
        }
        state.setMessage("");
        swapCurrentAndLastPlayer();
        MoveHelper moveHelper= new MoveHelper(state);
        if(!moveHelper.doesPlayerHaveAnyValidMoves(state.getCurrentPlayer())){
            state.setMessage(state.getCurrentPlayer().getName()+" has no valid moves!");
            swapCurrentAndLastPlayer();
        }
    }

    public void undo(){
        state.setLastPlayer(oldLastPlayer);
        state.setCurrentPlayer(oldCurrentPlayer);
    }

    public String getName(){
        return "Change of Turn";
    }

    private boolean isLastPlayerSet(){
        return state.getLastPlayer() != null;
    }

    private void swapCurrentAndLastPlayer(){
        Player newCurrentPlayer = state.getLastPlayer();
        state.setLastPlayer(state.getCurrentPlayer());
        state.setCurrentPlayer(newCurrentPlayer);
    }
}
