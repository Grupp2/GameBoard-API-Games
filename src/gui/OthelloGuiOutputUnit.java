package gui;

import game.api.GameState;
import game.io.OutputUnit;

public class OthelloGuiOutputUnit implements OutputUnit
{
	private boolean run = true;
	private OthelloGameFrame frame;
	public OthelloGuiOutputUnit(OthelloGameFrame othelloGameFrame) {
		frame = othelloGameFrame;	
	}

	@Override
	public void publish(GameState state) {
		frame.notifyOfPublish(state);
		if (run) {
			frame.buildGameFrame();
			run = false;
		}
		frame.placeGamePieces();
			
		
	}

}
