package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS285_Minimum_Difference {

    public int solve(int[] lst0, int[] lst1) {
        Arrays.sort(lst0);
        Arrays.sort(lst1);

        int ans = Integer.MAX_VALUE;

        int cur0 = 0, cur1 = 0;

        while (cur0 < lst0.length && cur1 < lst1.length) {
            ans = Math.min(ans, Math.abs(lst0[cur0] - lst1[cur1]));
            if (lst0[cur0] < lst1[cur1]) {
                cur0++;
            } else {
                cur1++;
            }
        }

        return ans;
    }
}
