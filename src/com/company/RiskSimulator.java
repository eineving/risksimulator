package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiskSimulator implements ActionListener{
    Combat model;
    InputPanel view = new InputPanel(this);

    public RiskSimulator(){
        JFrame frame = new JFrame("RiskSimulator");
        frame.add(view);
        frame.setVisible(true);
        frame.setSize(400,400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Simulate Outcome")){
            model = new Combat(view.getNbrOfAttackersInput(),view.getNbrOfDefendersInput());
            System.out.println("Simulate clicked");
            model.simulateOutcome();
        }
    }

    public static void main(String[] args) {
        new RiskSimulator();
    }
}
