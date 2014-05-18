package run;

import gui.GameFrame;
import gui.GameSelectorPanel;
import gui.listeners.GameSelectorListeners;
import othello.backend.OthelloGameFacade;
import othello.consoleui.OthelloConsoleIOFactory;
import game.init.Runner;

public class Program {

	public static void main(String[] args) {
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++)
				if (args[i].equals("--console") || args[i].equals("-c"))
					new Runner(new OthelloGameFacade(), new OthelloConsoleIOFactory()).run();
		} else {
            GameFrame theFrame = new GameFrame();
            theFrame.setTitle("Gameboard Project");

            GameSelectorPanel selectorPanel = new GameSelectorPanel();
            GameSelectorListeners listener = new GameSelectorListeners(selectorPanel, theFrame);

            listener.addGameSelectorListeners();
            theFrame.setContentPane(selectorPanel);
		}
	}
}
