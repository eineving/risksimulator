package com.company;

import java.util.ArrayList;

/**
 * Created by Daniel on 2014-11-16.
 */
public class Combat {
    private int nbrOfAttackers, nbrOfDefenders;

    public Combat(int attackers, int defenders) {
        this.nbrOfAttackers = attackers;
        this.nbrOfDefenders = defenders;
    }

    public void rollOnce() {

    }

    public void simulateOutcome() {

    }

    public boolean attackersWin() {
        //TODO fix
        return false;
    }

    private void executeResult(ArrayList<Die> attackers, ArrayList<Die> defenders) {
        int bigAttackValue = -1;
        int secondAttackValue = -1;
        int bigDefendValue = -1;
        int secondDefendValue = -1;

        if (attackers.size() > 3 || defenders.size() > 2) {
            throw new IllegalArgumentException("To many dice");
        }

        //region SettingValues
        //If the attacker has two or more dice
        if (attackers.size() > 1) {
            for (Die aDie : attackers) {
                if (aDie.getLastValue() > bigAttackValue) {
                    secondAttackValue = bigAttackValue;
                    bigAttackValue = aDie.getLastValue();
                } else if (aDie.getLastValue() > secondAttackValue) {
                    secondAttackValue = aDie.getLastValue();
                }
            }
        }

        //If the attacker has one die
        else {
            bigAttackValue = attackers.get(0).getLastValue();
        }

        //If the attacker has two or more dice
        if (defenders.size() > 1) {
            bigDefendValue = -1;
            secondDefendValue = -1;

            for (Die dDie : defenders) {
                if (dDie.getLastValue() > bigDefendValue) {
                    secondDefendValue = bigDefendValue;
                    bigDefendValue = dDie.getLastValue();
                } else if (dDie.getLastValue() > secondDefendValue) {
                    secondDefendValue = dDie.getLastValue();
                }
            }
        }

        //If the attacker has one die
        else {
            bigDefendValue = defenders.get(0).getLastValue();
        }
        //endregion


        //If the attacker is greater than the defender
        if (bigAttackValue > bigDefendValue) {
            nbrOfDefenders--;
        } else {
            nbrOfAttackers--;
        }

        if (attackers.size() > 1 && defenders.size() > 1) {
            if (secondAttackValue > secondDefendValue) {
                nbrOfDefenders--;
            } else {
                nbrOfAttackers--;
            }
        }

    }
}
