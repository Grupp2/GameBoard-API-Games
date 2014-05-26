package battleships.backend;

import java.awt.*;

public class Settings {

    public static final int PLAYER_ONE_INDEX = 0;

    public static final int PLAYER_TWO_INDEX = 1;


    public static final String PLAYER_ONE_NAME = "P1";

    public static final String PLAYER_TWO_NAME = "P2";


    public static final char PLAYER_ONE_PIECE_ID = '1';

    public static final char PLAYER_TWO_PIECE_ID = '2';


    public static final char SHIP_CARRIER_ID = '5';

    public static final char SHIP_BATTLE_SHIP_ID = '4';

    public static final char SHIP_SUBMARINE_ID = '3';

    public static final char SHIP_DESTROYER_ID = '2';

    public static final String DEPLOY_PIECE_ID = "DEPLOY";

    public static final char SHIP_ID = 'S';


    public static final String PIECE_ALREADYHIT = "H";

    public static final String PIECE_SHIP = "S";

    public static final String PIECE_MISS_ID = "MISS";

    public static final String PIECE_HIT_ID = "HIT";

    public static final String PIECE_ALREADYHIT_MESSAGE = "You've already shot at that location!";

    public static final String PIECE_SHIPHIT_MESSAGE = "You hit a ship!";

    public static final String PIECE_MISS_MESSAGE = "You missed!";

    public static final String PIECE_ACTION = "NOTIFYACTION";

    public static final Color PIECE_MISS_COLOR = Color.green;

    public static final Color PIECE_SHIPHIT_COLOR = Color.red;

    public static final Color PIECE_SHIP_COLOR = Color.orange;

    public static final Color TILE_COLOR = Color.blue;

    public static final int[] PIECE_COUNT = {0, 0, 4, 3, 2, 1};

    public static final int PIECE_TYPE_INDEX = 0;

    public static final int PIECE_OWNER_INDEX = 1;

    public static final int PIECE_LENGTH_INDEX = 2;

}

