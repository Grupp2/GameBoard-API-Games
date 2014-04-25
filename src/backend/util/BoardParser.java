package backend.util;

import game.impl.Board;
import game.impl.BoardLocation;

import java.util.ArrayList;
import java.util.List;


public class BoardParser {

    private Board gameBoard;

    private BoardLocation location;

    public BoardParser(Board gameBoard, BoardLocation location){
        this.gameBoard = gameBoard;
        this.location = location;
    }

    public BoardLocation getLocation(){
        return this.location;
    }


    public List<BoardLocation> getRow(){
        List<BoardLocation> board = gameBoard.getLocations();
        List<BoardLocation> row = new ArrayList<BoardLocation>();

        char rowChar = location.getId().charAt(0);

        for(int i = 0; i < board.size(); i++){
            if(board.get(i).getId().charAt(0) == rowChar)
                row.add(board.get(i));
        }

        return row;
    }

    public List<BoardLocation> getColumn(){
        List<BoardLocation> board = gameBoard.getLocations();
        List<BoardLocation> column = new ArrayList<BoardLocation>();

        char colChar = location.getId().charAt(1);

        for(int i = 0; i < board.size(); i++){
            if(board.get(i).getId().charAt(1) == colChar)
                column.add(board.get(i));
        }

        return column;
    }

    public List<BoardLocation> getLeftToRightDiagonal(){
        List<BoardLocation> board = gameBoard.getLocations();
        List<BoardLocation> diagonal = new ArrayList<BoardLocation>();

        int startPosition = board.indexOf(location);

        while(true){
            if(isFirstRow(board.get(startPosition)) || isFirstColumn(board.get(startPosition)))
                break;
            startPosition -= 9;
        }

        for(int i = startPosition; i < board.size(); i+=9){
            diagonal.add(board.get(i));

            if(isLastRow(board.get(i)) || isLastColumn(board.get(i)))
                break;
        }

        return diagonal;
    }

    public List<BoardLocation> getRightToLeftDiagonal(){
        List<BoardLocation> board = gameBoard.getLocations();
        List<BoardLocation> diagonal = new ArrayList<BoardLocation>();

        int startPosition = board.indexOf(location);

        while(true){
            if(isFirstRow(board.get(startPosition)) || isLastColumn(board.get(startPosition)))
                break;

            startPosition -= 7;
        }

        for(int i = startPosition; i < board.size(); i+=7){
            diagonal.add(board.get(i));

            if(isLastRow(board.get(i)) || isFirstColumn(board.get(i)))
                break;
        }

        return diagonal;
    }


    private boolean isFirstRow(BoardLocation location){
        return location.getId().charAt(0) == 'A';
    }

    private boolean isLastRow(BoardLocation location){
        return location.getId().charAt(0) == 'H';
    }

    private boolean isFirstColumn(BoardLocation location){
        return location.getId().charAt(1) == '1';
    }

    private boolean isLastColumn(BoardLocation location){
        return location.getId().charAt(1) == '8';
    }



}
