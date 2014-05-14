package run;

import othellobackend.OthelloGameFacade;
import othellogui.OthelloGameFrame;
import othellogui.OthelloGuiIOFactory;
import othellogui.OthelloGuiInputUnit;
import othellogui.OthelloGuiOutputUnit;
import othelloconsoleui.OthelloConsoleIOFactory;
import game.init.Runner;

public class Program {

	public static void main(String[] args) {
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++)
				if (args[i].equals("--console") || args[i].equals("-c"))
					new Runner(new OthelloGameFacade(), new OthelloConsoleIOFactory()).run();
		} else {
			OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
			OthelloGuiOutputUnit outputUnit = new OthelloGuiOutputUnit(new OthelloGameFrame(inputUnit));
			new Runner(new OthelloGameFacade(), new OthelloGuiIOFactory(inputUnit, outputUnit)).run();
		}
	}
}
