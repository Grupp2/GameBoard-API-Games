package battleships.gui.panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import battleships.backend.Settings;

public class BattleShipsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public BattleShipsPanel(JPanel p1Panel, JPanel p2Panel) {
		JPanel separatorPanel = new JPanel();
		separatorPanel.setBounds(0, 0, 50, 600);
		separatorPanel.setBackground(Settings.TILE_COLOR);
		this.setLayout(new BorderLayout());
		this.add(p1Panel, BorderLayout.LINE_START);
		this.add(separatorPanel, BorderLayout.CENTER);
		this.add(p2Panel, BorderLayout.LINE_END);
	}
}
