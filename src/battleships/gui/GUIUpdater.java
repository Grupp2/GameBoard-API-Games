package battleships.gui;


import battleships.backend.BattleShipsGameState;
import game.api.GameState;
import gui.GameUpdatable;

public class GUIUpdater implements GameUpdatable{

    private ContentPanel contentPanel;

    public GUIUpdater(ContentPanel panel){
        this.contentPanel = panel;
    }

    @Override
    public void update(GameState gameState) {

        updateMessages(gameState);
        updateGameBoard(gameState);

    }

    private void updateMessages(GameState gameState){
        contentPanel.setTurnMessage(gameState.getPlayerInTurn().getName());
        contentPanel.setNotificationMessage(gameState.getMessage());
    }

    private void updateGameBoard(GameState gameState){
        if(((BattleShipsGameState)gameState).getIsDeployMode()){
            contentPanel.displayDeployPanel();
        }
        else {
            contentPanel.displayNormalPanel();
        }
    }
}
