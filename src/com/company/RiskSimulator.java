package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiskSimulator implements ActionListener {
    Combat model;
    InputPanel view = new InputPanel(this);

    public RiskSimulator() {
        JFrame frame = new JFrame("RiskSimulator");
        frame.add(view);
        frame.setVisible(true);
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Simulate Outcome")) {
            model = new Combat(view.getNbrOfAttackersInput(), view.getNbrOfDefendersInput());
            System.out.println("Simulate clicked");
            model.simulateOutcome();
            try {
                if (model.attackersWin()) {
                    JOptionPane.showMessageDialog(null,"Attackers win with " + model.getNbrOfAttackers() +  " troops left");
                } else {
                    JOptionPane.showMessageDialog(null,"Defenders win with " + model.getNbrOfDefenders() +  " troops left");
                }
            } catch (Exception ignore) {
                //TODO Add handling
            }
        }
    }

    public static void main(String[] args) {
        new RiskSimulator();
    }
}
