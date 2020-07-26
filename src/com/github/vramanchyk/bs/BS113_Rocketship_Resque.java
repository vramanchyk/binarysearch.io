package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/26/20.
 */
public class BS113_Rocketship_Resque {

    public int solve(int[] weights, int limit) {

        Arrays.sort(weights);
        int l = 0, r = weights.length - 1;

        int count = 0;
        while (l < r) {
            count++;
            if (weights[l] + weights[r] <= limit) {
                l++;
                r--;
            } else if (weights[r] <= limit) {
                r--;
            }
        }

        if (l == r) {
            count++;
        }

        return count;
    }
}
