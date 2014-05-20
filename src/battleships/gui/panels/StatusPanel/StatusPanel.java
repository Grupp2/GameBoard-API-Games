package battleships.gui.panels.StatusPanel;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private MessagePanel messagePanel;
    private TurnPanel turnPanel;

    public StatusPanel(TurnPanel turnPanel, MessagePanel messagePanel, LayoutManager layout){
        this.turnPanel = turnPanel;
        this.messagePanel = messagePanel;

        setLayout(layout);
        appendTurnPanel();
        appendMessagePanel();
    }

    public StatusPanel(){
        this(new TurnPanel(), new MessagePanel(), new GridBagLayout());
    }

    private void appendTurnPanel(){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;

        add(turnPanel, constraints);
    }

    private void appendMessagePanel(){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;

        add(messagePanel, constraints);
    }


    public void setNotificationMessage(String text){
        messagePanel.setMessage(text);
    }

    public void setTurnMessage(String text){
        turnPanel.setMessage(text);
    }

}
