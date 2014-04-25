package backend;

import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

import java.util.ArrayList;
import java.util.List;

public class StateBuilder {

    private State state = new State();


    public void buildDefault(){
        initPlayers();
        setPlayer1(new Player("player1", new ArrayList<GamePiece>()));
        setPlayer2(new Player("player2", new ArrayList<GamePiece>()));
        setBoard(new Board(makeOthelloBoardLocations()));
    }


    public void initPlayers(){
        state.setPlayers(new ArrayList<Player>());
    }

    public void setPlayer1(Player player){
        if(state.getPlayers() == null)
           initPlayers();

        state.getPlayers().add(0, player);
    }

    public Player getPlayer1(){
        return state.getPlayers().get(0);
    }


    public void setPlayer2(Player player){
        if(state.getPlayers() == null)
            initPlayers();

        state.getPlayers().add(1, player);
    }

    public Player getPlayer2(){
        return state.getPlayers().get(1);
    }


    public void setBoard(Board board){
        state.setBoard(board);
    }

    public void setBoardLocations(List<BoardLocation> locations){
        state.getBoard().getLocations().clear();
        state.getBoard().getLocations().addAll(locations);
    }


    public List<BoardLocation> makeOthelloBoardLocations(){
        List<BoardLocation> list = new ArrayList<BoardLocation>();

        for(int j = (int)'A'; j <= (int)'H'; j++)
            for(int i = 1; i <= 8; i++)
                list.add(new BoardLocation(""+(char)j+i));

        return list;
    }


    public State getState(){
        return state;
    }
}
