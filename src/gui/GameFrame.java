package gui;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public GameFrame(){
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void setContentPane(Container container){
        super.setContentPane(container);

        container.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                pack();
            }
        });
    }
}
