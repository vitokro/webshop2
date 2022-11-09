package com.livatek.calcs;

public class FreightCalculatorImpl implements FreightCalculator{

    /**
     * Freight depends on the amount of products.
     * • Up to and including 10 items: 50,-
     * • For each additional 10 items: 25,-
     * @param amount
     * @return
     */
    @Override
    public long calculate(long amount) {
        int freightCost = 50;
        if (amount > 10) {
            freightCost += 25 * (amount / 10) ;
        }
        return freightCost;
    }
}
