package battleships.gui.panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import battleships.backend.Settings;

public class BattleShipsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

    private JPanel playerOnePanel;

    private JPanel playerTwoPanel;

	public BattleShipsPanel(JPanel p1Panel, JPanel p2Panel) {
		JPanel separatorPanel = new JPanel();

        playerOnePanel = p1Panel;
        playerTwoPanel = p2Panel;

		separatorPanel.setBounds(0, 0, 50, 600);
		separatorPanel.setBackground(Settings.TILE_COLOR);

        setLayout(new BorderLayout());

        add(p1Panel, BorderLayout.LINE_START);
		add(separatorPanel, BorderLayout.CENTER);
		add(p2Panel, BorderLayout.LINE_END);
	}

    public JPanel getPlayerOnePanel(){
        return playerOnePanel;
    }

    public JPanel getPlayerTwoPanel(){
        return playerTwoPanel;
    }
}
