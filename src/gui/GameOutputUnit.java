package gui;


import game.api.GameState;
import game.io.OutputUnit;

import javax.swing.*;

public class GameOutputUnit implements OutputUnit{

    private GameUpdatable guiUpdater;

    private ContentPanelCreatable guiContentPanel;

    private JPanel contentPane;

    private boolean isContentPanelCreated = false;

    public GameOutputUnit(GameUpdatable guiUpdater, ContentPanelCreatable guiContentPanel, JPanel contentPane){
        this.guiUpdater = guiUpdater;
        this.guiContentPanel = guiContentPanel;
        this.contentPane = contentPane;
    }

    @Override
    public void publish(GameState gameState) {
        if(!isContentPanelCreated){
            guiContentPanel.createGuiPanel(contentPane);
            isContentPanelCreated = true;
        }

        guiUpdater.update(gameState);
    }
}
