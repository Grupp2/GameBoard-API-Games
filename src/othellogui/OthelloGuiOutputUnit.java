package othellogui;

import game.api.GameState;
import game.io.OutputUnit;

public class OthelloGuiOutputUnit implements OutputUnit
{
	private OthelloGameFrame frame;
	public OthelloGuiOutputUnit(OthelloGameFrame othelloGameFrame) {
		frame = othelloGameFrame;	
	}

	@Override
	public void publish(GameState state) {
		frame.notifyOfPublish(state);
	}

}
