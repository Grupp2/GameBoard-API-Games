package battleships.gui.panels;

import game.api.GameState;
import game.impl.BoardLocation;
import gui.GameBoardSizeCalculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import translator.TranslatorAdapter;

public class BattleshipGameBoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private final Color BACKGROUND_BLUE = new Color(160, 240, 167, 255);

	private int xSize;
	private int ySize;

    private List<JButton> buttons = new ArrayList<>();

	public BattleshipGameBoardPanel(GameState state, TranslatorAdapter ta) {
		setPreferredSize(new Dimension(600, 600));

		calculateBoardSize(state, ta);
		setLayout(new GridLayout(xSize, ySize));
		addButtons(state);
	}

	private void calculateBoardSize(GameState gameState, TranslatorAdapter ta) {
		GameBoardSizeCalculator calc = new GameBoardSizeCalculator();
		int[] result = calc.calculateBoardSize(gameState, ta);
		this.xSize = result[0];
		this.ySize = result[1];
	}

	private void addButtons(GameState state) {
		List<BoardLocation> locations = state.getBoard().getLocations();

		for (int i = 0; i < locations.size(); i++) {
			JButton btn = new JButton();
			btn.setName(locations.get(i).getId());
			btn.setBackground(BACKGROUND_BLUE);
			add(btn);
            buttons.add(btn);
		}
	}

    public JButton getButton(int i){
        return buttons.get(i);
    }
}
