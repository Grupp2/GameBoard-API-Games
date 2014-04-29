package run;

import game.init.Runner;
import gui.OthelloGameFrame;
import gui.OthelloGuiIOFactory;
import gui.OthelloGuiInputUnit;
import gui.OthelloGuiOutputUnit;
import backend.OthelloGameState;

public class ProgramGUI {

	public static void main(String[] args) {
		OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
		OthelloGuiOutputUnit outputUnit = new OthelloGuiOutputUnit(new OthelloGameFrame(inputUnit));
		new Runner(new OthelloGameState(), new OthelloGuiIOFactory(inputUnit, outputUnit)).run();
	}
}
