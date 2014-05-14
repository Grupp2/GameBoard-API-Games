package run;

import gui.GameFrame;
import gui.GameSelectorPanel;
import gui.listeners.GameSelectorListeners;

public class FrameMain {

	public static void main(String[] args){
        GameFrame theFrame = new GameFrame();
        theFrame.setTitle("Gameboard Project");
        GameSelectorPanel selectorPanel = new GameSelectorPanel();
        GameSelectorListeners listener = new GameSelectorListeners(selectorPanel, theFrame);
        listener.addGameSelectorListeners();
        theFrame.setContentPane(selectorPanel);
    }
}
