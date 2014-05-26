package battleships.gui.panels.StatusPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MessagePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel messageLabel;

    public MessagePanel(JLabel label, LayoutManager layout, Border border){
        messageLabel = label;

        setLayout(layout);
        setBorder(border);
        add(messageLabel);
    }

    public MessagePanel(){
        this(new JLabel(), new FlowLayout(), BorderFactory.createTitledBorder("Message"));
    }

    public void setMessage(String message){
        messageLabel.setText(message);
    }

    public String getMessage(){
        return messageLabel.getText();
    }

}
