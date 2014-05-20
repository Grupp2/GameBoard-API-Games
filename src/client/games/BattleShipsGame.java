package client.games;

import battleships.backend.BattleShipsGameState;
import battleships.gui.BattleShipsInputUnit;
import battleships.gui.ContentPanel;
import battleships.gui.GUIUpdater;
import battleships.gui.panels.BattleshipDeployPanel;
import game.api.GameState;
import game.init.Runner;
import game.io.OutputUnit;
import gui.GameIoFactory;
import gui.GameOutputUnit;

import javax.swing.*;

public class BattleShipsGame implements GameStartup{

    private GameState gameState;
    private GameIoFactory ioFactory;
    private JPanel contentPanel;

    public BattleShipsGame(){
        setupObjects();
    }

    private void setupObjects(){
        GameState gameState = new BattleShipsGameState();
        gameState.reset();

        BattleShipsInputUnit inputUnit = new BattleShipsInputUnit();

        BattleshipDeployPanel deployPanel = new BattleshipDeployPanel(gameState, inputUnit);

        ContentPanel contentPanel = new ContentPanel(inputUnit, deployPanel);

        GUIUpdater guiUpdater = new GUIUpdater(contentPanel);

        OutputUnit outputUnit = new GameOutputUnit(guiUpdater);

        this.gameState = gameState;
        this.ioFactory = new GameIoFactory(inputUnit, outputUnit);
        this.contentPanel = contentPanel;
    }

    @Override
    public JPanel getContentPane() {
        return contentPanel;
    }

    @Override
    public void start() {

        new Runner(gameState, ioFactory).run();
    }
}
