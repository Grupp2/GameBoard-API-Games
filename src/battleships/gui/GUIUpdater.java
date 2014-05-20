package battleships.gui;


import battleships.BattleShipsGameState;
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

        updateMessages(gameState);

       /* if(gameState.getPlayerInTurn().getName().equals(Settings.PLAYER_ONE_NAME))
            contentPanel.displayPlayerOneBoard();
        else
            contentPanel.displayPlayerTwoBoard();*/
    }

    private void updateMessages(GameState gameState){
        contentPanel.setTurnMessage(gameState.getPlayerInTurn().getName());
        contentPanel.setNotificationMessage(gameState.getMessage());
    }

    private void updateGameBoard(GameState gameState){
        if(((BattleShipsGameState)gameState).getIsDeployMode()){
            
        }
        else {

        }
    }
}
