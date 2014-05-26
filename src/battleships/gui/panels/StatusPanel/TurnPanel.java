package battleships.gui.panels.StatusPanel;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TurnPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel turnLabel;

    public TurnPanel(JLabel label, LayoutManager layout, Border border){
        turnLabel = label;

        setLayout(layout);
        setBorder(border);
        add(turnLabel);
    }

    public TurnPanel(){
        this(new JLabel(), new FlowLayout(), BorderFactory.createTitledBorder("Current turn"));
    }

    public void setMessage(String message){
        turnLabel.setText(message);
    }

    public String getMessage(){
        return turnLabel.getText();
    }


}
