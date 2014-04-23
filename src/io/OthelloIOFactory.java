package io;

import game.io.InputUnit;
import game.io.IoFactory;
import game.io.OutputUnit;

public class OthelloIOFactory implements IoFactory
{
    private OthelloConsoleInputUnit inputUnit = new OthelloConsoleInputUnit();
    private OthelloConsoleOutputUnit outputUnit = new OthelloConsoleOutputUnit();
	@Override
	public InputUnit getInputUnit()
	{
		return inputUnit;
	}

	@Override
	public OutputUnit getOutputUnit()
	{
		return outputUnit;
	}

}
