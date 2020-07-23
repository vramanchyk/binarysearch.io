package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS291_Lego_Towers {

    public int solve(int[] heights, int k) {
        Arrays.sort(heights);

        int sum = 0;
        for (int idx = 0; idx < k; idx++) {
            sum += heights[idx];
        }

        int target = heights[k - 1] * k;
        int min = target - sum;

        for (int idx = k; idx < heights.length; idx++) {
            sum += heights[idx] - heights[idx - k];
            target = heights[idx] * k;
            min = Math.min(min, target - sum);
        }

        return min;
    }
}
