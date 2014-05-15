package gui;


import game.api.GameState;
import game.io.OutputUnit;

public class GameOutputUnit implements OutputUnit{

    private GameUpdatable guiUpdater;

    private ContentPanelCreatable guiContentPanel;

    private boolean isContentPanelCreated = false;

    public GameOutputUnit(GameUpdatable guiUpdater, ContentPanelCreatable guiContentPanel){
        this.guiUpdater = guiUpdater;
        this.guiContentPanel = guiContentPanel;
    }

    @Override
    public void publish(GameState gameState) {
        if(!isContentPanelCreated){
            guiContentPanel.createGuiPanel();
            isContentPanelCreated = true;
        }

        guiUpdater.update(gameState);
    }
}
