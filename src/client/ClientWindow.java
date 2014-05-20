package client;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ClientWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	public ClientWindow(){
        setMinimumSize(new Dimension(599, 599));
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
