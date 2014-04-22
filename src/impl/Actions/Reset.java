package impl.Actions;


import impl.OthelloGameFactory;
import impl.State;
import impl.util.GameRules;

public class Reset {

    private State state;
    private OthelloGameFactory factory;

    public Reset(State state, OthelloGameFactory factory){
        this.state = state;
        this.factory = factory;
    }

    public void execute(){
        state.setPlayers(factory.createPlayers());
        state.setBoard(factory.createBoard());
        state.setTurnCounter(factory.createTurnCounter(state.getPlayers(), state.getPlayers().get(0)));
        state.setMessage("");

        GameRules.setStartingPositions(state.getPlayers(), state.getBoard());
    }

}
