package battleships.gui.panels;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import battleships.BattleShipsInputUnit;
import translator.TranslatorAdapter;

public class GameGridListeners {
    private JButton selectedButton;
    private JPanel contentPanel;
    private TranslatorAdapter translator;
    private BattleShipsInputUnit inputUnit;
    public GameGridListeners(JPanel contentPanel, BattleShipsInputUnit inputUnit, TranslatorAdapter translator) {
	this.contentPanel = contentPanel;
	this.translator = translator;
	this.inputUnit = inputUnit;
    }
    public void addButtonListeners() {
	for (Component button : contentPanel.getComponents()) {
	    if (button instanceof JButton)
		((JButton) button).addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent event) {
			//TODO what to do
			selectedButton = (JButton) event.getSource();
		    }
		});
	}	
    }
    
    private void createMove() {
	inputUnit.notifyListeners(translator.translateFromUiToGameState(selectedButton.getName()));
    }
}
