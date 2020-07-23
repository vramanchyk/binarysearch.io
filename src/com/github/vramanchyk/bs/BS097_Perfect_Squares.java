package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS097_Perfect_Squares {

    public int solve(int n) {
        final int[] ans = new int[n + 1];

        for (int num = 1; num <= n; num++) {
            ans[num] = num;

            for (int sq = 1; num - sq * sq >= 0; sq++) {
                ans[num] = Math.min(ans[num], ans[num - sq * sq] + 1);
            }
        }

        return ans[n];
    }
}
