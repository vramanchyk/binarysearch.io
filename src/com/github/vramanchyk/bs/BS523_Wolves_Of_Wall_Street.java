package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS523_Wolves_Of_Wall_Street {

    public int solve(int[] prices) {

        int index = 0;
        int profit = 0;

        while (index < prices.length) {
            int forward = index;

            while (forward + 1 < prices.length && prices[forward + 1] >= prices[forward]) {
                forward++;
            }

            if (forward > index) {
                profit += prices[forward] - prices[index];
            }

            index = forward + 1;
        }

        return profit;
    }
}