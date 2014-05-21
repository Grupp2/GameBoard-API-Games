package battleships.backend;

import java.awt.*;

public class Settings {

    public static final String PLAYER_ONE_NAME = "P1";

    public static final String PLAYER_TWO_NAME = "P2";


    public static final char PLAYER_ONE_PIECE_ID = '1';

    public static final char PLAYER_TWO_PIECE_ID = '2';


    public static final char SHIP_CARRIER_ID = '5';

    public static final char SHIP_BATTLE_SHIP_ID = '4';

    public static final char SHIP_SUBMARINE_ID = '3';

    public static final char SHIP_DESTROYER_ID = '2';


    public static final int PLAYER_ONE_INDEX = 0;

    public static final int PLAYER_TWO_INDEX = 1;

    public static final char PIECE_ALREADYHIT = 'H';

    public static final char PIECE_SHIP = 'S';

    public static final char PIECE_MISS = 'M';

    public static final String PIECE_ALREADYHIT_MESSAGE = "You've already shot at that location!";

    public static final String PIECE_SHIPHIT_MESSAGE = "You hit a ship!";

    public static final String PIECE_MISS_MESSAGE = "You missed!";

    public static final String PIECE_ACTION = "NOTIFYACTION";

    public static final Color PIECE_MISS_COLOR = new Color(58,241,58,255);

    public static final Color PIECE_SHIPHIT_COLOR = new Color(241,58,258,255);

}
