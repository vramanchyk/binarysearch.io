package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 8/4/20.
 */
public class BS287_Buying_Cars {

    public int solve(int[] prices, int k) {
        Arrays.sort(prices);

        int count = 0;
        while (count < prices.length && k - prices[count] >= 0) {
            k -= prices[count];
            count++;
        }

        return count;
    }
}
