package backend.undoable;

import backend.State;
import backend.util.BoardParser;
import game.impl.Move;

public class MoveAction implements UndoableAction{

    private State state;
    private Move move;

    private UndoableAction turnIncrement;
    private UndoableAction boardUpdate;

    public MoveAction(State state, Move move){
        this.state = state;
        this.move = move;

        this.turnIncrement = new TurnIncrement(state);
        this.boardUpdate = new BoardUpdate(state, new BoardParser(state.getBoard(), move.getDestination()));
    }

    @Override
    public void execute() {
        executeMove();
        boardUpdate.execute();
        turnIncrement.execute();
    }

    @Override
    public void undo() {
        turnIncrement.undo();
        boardUpdate.undo();
        undoMove();
    }

    @Override
    public String getName() {
        return "Move";
    }

    private void executeMove(){
        move.getDestination().setPiece(move.getPiece());
        state.getCurrentPlayer().getPieces().add(move.getPiece());
    }

    private void undoMove(){
        move.getDestination().setPiece(null);
        state.getCurrentPlayer().getPieces().remove(move.getPiece());
    }
}
