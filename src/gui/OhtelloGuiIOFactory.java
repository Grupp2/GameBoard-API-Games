package gui;

import game.io.InputUnit;
import game.io.IoFactory;
import game.io.OutputUnit;

public class OhtelloGuiIOFactory implements IoFactory{
	private InputUnit inputUnit = new OthelloGuiInputUnit();
	private OutputUnit outputUnit = new OthelloGuiOutputUnit();

	@Override
	public InputUnit getInputUnit() {
		return inputUnit;
	}

	@Override
	public OutputUnit getOutputUnit() {
		return outputUnit;
	}

	public void getGameFrame(){
//		outputUnit.setGameFrame(inputUnit.getGameFrame());
	}
}
