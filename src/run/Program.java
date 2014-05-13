package run;

import backend.OthelloGameState;
import io.OthelloConsoleIOFactory;
import game.init.Runner;
import gui.OthelloGameFrame;
import gui.OthelloGuiIOFactory;
import gui.OthelloGuiInputUnit;
import gui.OthelloGuiOutputUnit;

public class Program
 {

	public static void main(String[] args) {
	    	if (args.length > 0) {
	    	    for (int i = 0; i < args.length; i++) {
	    		if (args[i].equals("-console"))
	    		    new Runner(new OthelloGameState(), new OthelloConsoleIOFactory()).run();
	    	    }
	    	} else {
    	    	    OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
    		    OthelloGuiOutputUnit outputUnit = new OthelloGuiOutputUnit(new OthelloGameFrame(inputUnit));
    		    new Runner(new OthelloGameState(), new OthelloGuiIOFactory(inputUnit, outputUnit)).run();
	    	}
	}

}
