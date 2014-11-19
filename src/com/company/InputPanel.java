package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 * Created by Test on 2014-11-16.
 */
public class InputPanel extends JPanel{
    private JLabel nbrOfDeffender = new JLabel("Defenders: ");
    private JLabel nbrOfAttackers = new JLabel("Attackers: ");
    private JSpinner deffenderInput = new JSpinner();
    private JSpinner attackerInput = new JSpinner();
    private JButton simulateButton = new JButton("Simulate Outcome");
    private GridLayout layout = new GridLayout(2,1);
    private GridLayout upperLayout = new GridLayout(2,2);
    private JPanel upperPart = new JPanel();

    public InputPanel(ActionListener listener){
        super();

        upperPart.setLayout(upperLayout);
        upperPart.setVisible(true);
        upperPart.add(nbrOfAttackers);
        upperPart.add(attackerInput);
        upperPart.add(nbrOfDeffender);
        upperPart.add(deffenderInput);

        setLayout(layout);
        setVisible(true);
        add(upperPart);
        add(simulateButton);

        simulateButton.addActionListener(listener);
        simulateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                firePropertyChange("simulateOutcome", true, false);
            }
        });

    }
    public int getNbrOfAttackersInput(){
        return Integer.valueOf(attackerInput.getValue().toString());
    }

    public int getNbrOfDefendersInput(){
        return Integer.valueOf(deffenderInput.getValue().toString());
    }

}
