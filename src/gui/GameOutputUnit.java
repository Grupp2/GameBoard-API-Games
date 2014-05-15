package gui;


import game.api.GameState;
import game.io.OutputUnit;

public class GameOutputUnit implements OutputUnit{

    private GameUpdatable guiUpdater;

    private ContentPanelCreatable guiContentPanel;

    private GameFrame frame;

    private boolean isContentPanelCreated = false;

    public GameOutputUnit(GameUpdatable guiUpdater, ContentPanelCreatable guiContentPanel, GameFrame frame){
        this.guiUpdater = guiUpdater;
        this.guiContentPanel = guiContentPanel;
        this.frame = frame;
    }

    @Override
    public void publish(GameState gameState) {
        if(!isContentPanelCreated){
            frame.setContentPane(guiContentPanel.createGuiPanel());
            isContentPanelCreated = true;
            frame.pack();
        }

        guiUpdater.update(gameState);
    }
}
