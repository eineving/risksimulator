package com.company;

/**
 * Created by Daniel Eineving on 2014-11-16.
 */
public class Die {
    private int lastValue = -1;
    private int sides;

    /**
     * Create a new die
     * @param sides nbr of sides on the die
     */
    public Die(int sides) {
        this.sides = sides;
    }

    public int rollDie() {
        lastValue = (int) (Math.random() * sides) + 1;
        return lastValue;
    }

    /**
     * Get last value of the die
     *
     * @return the last value, -1 if the die have never been rolled
     */
    public int getLastValue() {
        return lastValue;
    }
}
