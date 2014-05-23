package client.games;

import battleships.backend.BattleShipsGameState;
import battleships.gui.BattleShipsInputUnit;
import battleships.gui.ContentPanel;
import battleships.gui.GUIUpdater;
import battleships.gui.listeners.BattleShipsGamePanelListeners;
import battleships.gui.panels.BattleShipsPanel;
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
        BattleshipGamePanels gamePanels2 = new BattleshipGamePanels(gameState, ta);
        
        JPanel p1Panel = gamePanels.getPlayer1();
        JPanel p2Panel = gamePanels.getPlayer2();
        BattleShipsGamePanelListeners panelListener = new BattleShipsGamePanelListeners(p1Panel, inputUnit, ta);
        panelListener.addButtonListeners();
        panelListener = new BattleShipsGamePanelListeners(p2Panel, inputUnit, ta);
        panelListener.addButtonListeners();
        panelListener = new BattleShipsGamePanelListeners(gamePanels2.getPlayer1(), inputUnit, ta);
        panelListener.addButtonListeners();
        panelListener = new BattleShipsGamePanelListeners(gamePanels2.getPlayer2(), inputUnit, ta);
        panelListener.addButtonListeners();
        ContentPanel contentPanel = new ContentPanel(inputUnit, p2Panel);
        JPanel normalGamePanel = new BattleShipsPanel(gamePanels2.getPlayer1(), gamePanels2.getPlayer2());
        GUIUpdater guiUpdater = new GUIUpdater(contentPanel, p1Panel, p2Panel, normalGamePanel);

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
