package gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public GameFrame(){
        setMinimumSize(new Dimension(400, 400));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
