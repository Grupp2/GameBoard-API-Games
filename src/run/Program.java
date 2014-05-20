package run;

import client.ClientWindow;
import client.GameSelectionListener;
import client.GameSelectionPanel;
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
            ClientWindow theFrame = new ClientWindow();
            theFrame.setTitle("Gameboard Project");

            GameSelectionPanel selectorPanel = new GameSelectionPanel();
            GameSelectionListener listener = new GameSelectionListener(selectorPanel, theFrame);

            listener.addGameSelectorListeners();
            theFrame.setContentPane(selectorPanel);
            theFrame.pack();
		}
	}
}
