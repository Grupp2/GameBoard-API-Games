package gui;

import game.io.InputUnit;
import game.io.IoFactory;
import game.io.OutputUnit;
import io.OthelloConsoleInputUnit;
import io.OthelloConsoleOutputUnit;

public class OhtelloGuiIOFactory implements IoFactory{
	private OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
	private OthelloGuiOutputUnit outputUnit = new OthelloGuiOutputUnit();

	@Override
	public InputUnit getInputUnit() {
		return inputUnit;
	}

	@Override
	public OutputUnit getOutputUnit() {
		return outputUnit;
	}

}
