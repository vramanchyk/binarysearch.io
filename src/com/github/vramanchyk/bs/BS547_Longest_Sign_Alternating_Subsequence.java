package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS547_Longest_Sign_Alternating_Subsequence {

    public int solve(int[] nums) {
        int pos = 0;
        int neg = 0;

        for (int num : nums) {
            if (num < 0) {
                neg = pos + 1;
            } else {
                pos = neg + 1;
            }
        }

        return Math.max(pos, neg);
    }
}
