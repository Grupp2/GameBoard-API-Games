package generics;

import game.api.GameState;
import game.impl.BoardLocation;
import generics.GameBoardSizeCalculator;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import translator.TranslatorAdapter;

public class GameBoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Color backgroundColor;

	private int xSize;
	private int ySize;

    private List<JButton> buttons = new ArrayList<>();

	public GameBoardPanel(GameState state, TranslatorAdapter ta, Color buttonColor) {
		setPreferredSize(new Dimension(600, 600));
        this.backgroundColor = buttonColor;
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
			btn.setBackground(backgroundColor);
			add(btn);
            buttons.add(btn);
		}
	}

    public JButton getButton(int i){
        return buttons.get(i);
    }
}
