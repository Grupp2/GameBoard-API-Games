package client.games;

import battleships.backend.BattleShipsGameState;
import battleships.gui.BattleShipsInputUnit;
import battleships.gui.ContentPanel;
import battleships.gui.GUIUpdater;
import battleships.gui.listeners.BattleShipsGamePanelListeners;
import battleships.gui.panels.BattleshipGamePanels;
import game.api.GameState;
import game.init.Runner;
import game.io.OutputUnit;
import generics.GameIoFactory;
import generics.GameOutputUnit;
import javax.swing.*;
import translator.CoordinateTranslator;
import translator.TranslatorAdapter;

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
        TranslatorAdapter ta = new TranslatorAdapter(new CoordinateTranslator());
        BattleshipGamePanels gamePanels = new BattleshipGamePanels(gameState, ta);
        
        JPanel deployPanelP1 = gamePanels.getPlayer1();
        JPanel deployPanelP2 = gamePanels.getPlayer2();
        BattleShipsGamePanelListeners panelListener = new BattleShipsGamePanelListeners(deployPanelP1, inputUnit, ta);
        panelListener.addButtonListeners();
        panelListener = new BattleShipsGamePanelListeners(deployPanelP2, inputUnit, ta);
        panelListener.addButtonListeners();
        ContentPanel contentPanel = new ContentPanel(inputUnit, deployPanelP1);

        GUIUpdater guiUpdater = new GUIUpdater(contentPanel, deployPanelP1, deployPanelP2);

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
