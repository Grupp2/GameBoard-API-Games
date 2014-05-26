package battleships.backend.actionhelpers;

import battleships.backend.Settings;
import battleships.backend.State;
import battleships.backend.classhelpers.BoardHelper;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

import java.util.List;

/**
 * Created by hugg on 2014-05-26.
 */
public class WinnerCalculation {
    private State state;
    private BoardHelper helper;

    public WinnerCalculation(State state) {
        this.state = state;
        this.helper = new BoardHelper(state);
    }
    public Player getWinner() {
        List<BoardLocation> playerOneLocations = helper.getPlayerOneBoardHalf();
        List<BoardLocation> playerTwoLocations = helper.getPlayerTwoBoardHalf();

        if (getScore(playerTwoLocations) == 30) {
            return state.getPlayers().get(Settings.PLAYER_ONE_INDEX);
        } else if (getScore(playerOneLocations) == 30) {
            return state.getPlayers().get(Settings.PLAYER_TWO_INDEX);
        }
        return null;
    }

    private int getScore(List<BoardLocation> playerLocations) {
        int score = 0;
        for (BoardLocation loc : playerLocations) {
            GamePiece piece;
            if ((piece = loc.getPiece()) != null) {
                if (piece.getId().equals(Settings.PIECE_HIT_ID))
                    score++;
            }
        }
        return score;
    }

    public boolean isGameOver() {
        return getScore(helper.getPlayerOneBoardHalf()) == 30 || getScore(helper.getPlayerTwoBoardHalf()) == 30;
    }

}
