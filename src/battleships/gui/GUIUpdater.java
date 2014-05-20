package battleships.gui;


import game.api.GameState;
import gui.GameUpdatable;
import othello.backend.Settings;

public class GUIUpdater implements GameUpdatable{

    private ContentPanel contentPanel;

    public GUIUpdater(ContentPanel panel){
        this.contentPanel = panel;
    }

    @Override
    public void update(GameState gameState) {
       /* if(gameState.getPlayerInTurn().getName().equals(Settings.PLAYER_ONE_NAME))
            contentPanel.displayPlayerOneBoard();
        else
            contentPanel.displayPlayerTwoBoard();*/
    }

}
