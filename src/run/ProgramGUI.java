package run;

import game.init.Runner;
import gui.OhtelloGuiIOFactory;
import backend.OthelloGameState;

public class ProgramGUI {

	public static void main(String[] args) {
		new Runner(new OthelloGameState(), new OhtelloGuiIOFactory()).run();
	}
}
