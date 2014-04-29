package gui;

import game.io.InputUnit;
import game.io.IoFactory;
import game.io.OutputUnit;

public class OthelloGuiIOFactory implements IoFactory{
	private InputUnit inputUnit;
	private OutputUnit outputUnit;

	public OthelloGuiIOFactory(InputUnit inputUnit, OutputUnit outputUnit) {
		this.inputUnit = inputUnit;
		this.outputUnit = outputUnit;
	}
	@Override
	public InputUnit getInputUnit() {
		return inputUnit;
	}

	@Override
	public OutputUnit getOutputUnit() {
		return outputUnit;
	}
}