package generics;

import game.api.GameState;
import game.io.OutputUnit;

public class GameOutputUnit implements OutputUnit{

    private GameUpdatable guiUpdater;

    public GameOutputUnit(GameUpdatable guiUpdater){
        this.guiUpdater = guiUpdater;
    }

    @Override
    public void publish(GameState gameState) {
        guiUpdater.update(gameState);
    }
}
