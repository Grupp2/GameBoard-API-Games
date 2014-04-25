package backend.undoable;


public interface UndoableAction {

    public void undo();

    public void execute();

    public String getName();

}
