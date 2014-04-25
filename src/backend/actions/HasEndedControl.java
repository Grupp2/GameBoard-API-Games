package backend.actions;


import backend.State;

public class HasEndedControl {

    private State state;

    public HasEndedControl(State state){
        this.state = state;
    }

    public boolean execute(){
        int playerOnePieceCount = state.getPlayers().get(0).getPieces().size();
        int playerTwoPieceCount = state.getPlayers().get(1).getPieces().size();

        if(playerOnePieceCount + playerTwoPieceCount >= 64)
            return true;

        if(playerOnePieceCount == 0 || playerTwoPieceCount == 0)
            return true;

        return false;
    }

}
