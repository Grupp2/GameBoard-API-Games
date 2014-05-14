package othelloconsoleui;


import game.api.GameState;
import game.impl.Board;
import game.io.OutputUnit;
import game.impl.*;

public class OthelloConsoleOutputUnit implements OutputUnit {
    @Override
    public void publish(GameState gameState) {
        System.out.println(getOutputString(gameState)); 
        if (gameState.hasEnded()) {
        	System.out.println(gameState.getWinner().getName() + " has won the game!");
        } else {
        	System.out.println(gameState.getMessage());
        	System.out.print("Player " + gameState.getPlayerInTurn().getName() + " >");
        }
    }
    
    String getOutputString(GameState gameState){
    	Board board = gameState.getBoard();
        GamePiece piece;
        String outputString = new String();
        outputString += "  1  2  3  4  5  6  7  8 \n";
        char[] rows = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
        int b = 0;
        int lim = 8;
        for (int i = 0; i < 8; i++) {
        	outputString += (rows[i] + " ");
        	for (;b < lim; b++) {
        		if ((piece = board.getLocations().get(b).getPiece()) != null)
        			outputString += piece.getId() + "  ";
        		else
        			outputString += "·  ";
        	}
        	lim += 8;
        	outputString += "\n";
        }
        return outputString;
    }
}
