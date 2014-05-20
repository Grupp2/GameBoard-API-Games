package client.games;


import game.api.GameState;
import game.init.Runner;
import game.io.OutputUnit;
import gui.GameIoFactory;
import gui.GameOutputUnit;
import othello.backend.OthelloGameFacade;
import othello.gui.OthelloContentPanel;
import othello.gui.OthelloGuiInputUnit;
import othello.gui.OthelloGuiUpdater;

import javax.swing.*;

public class OthelloGame implements GameStartup{

    private GameState gameState;
    private GameIoFactory ioFactory;
    private JPanel contentPanel;

    public OthelloGame(){
        setupObjects();
    }


    private void setupObjects(){
        GameState gameState = new OthelloGameFacade();
        gameState.reset();

        OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
        OthelloContentPanel contentPanel = new OthelloContentPanel(gameState, inputUnit);

        OthelloGuiUpdater guiUpdater = new OthelloGuiUpdater(contentPanel);

        OutputUnit outputUnit = new GameOutputUnit(guiUpdater);

        this.gameState = gameState;
        this.ioFactory = new GameIoFactory(inputUnit, outputUnit);
        this.contentPanel = contentPanel;
    }

    @Override
    public JPanel getContentPane(){
        return contentPanel;
    }

    @Override
    public void start(){
        new Runner(gameState, ioFactory).run();
    }

}
