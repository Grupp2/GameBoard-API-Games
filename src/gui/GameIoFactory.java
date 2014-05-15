package gui;

import game.io.InputUnit;
import game.io.IoFactory;
import game.io.OutputUnit;

public class GameIoFactory implements IoFactory {

    private InputUnit inputUnit;
    private OutputUnit outputUnit;

    public GameIoFactory(InputUnit inputUnit, OutputUnit outputUnit) {
        this.inputUnit = inputUnit;
        this.outputUnit = outputUnit;
    }

    @Override
    public InputUnit getInputUnit() {
        return null;
    }

    @Override
    public OutputUnit getOutputUnit() {
        return null;
    }
}
