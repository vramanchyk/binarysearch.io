package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/15/20.
 */
public class BS047_Largest_K_Divisible_Subsequence {

    public int solve(int[] nums, int k) {

        int[][] sumRem = new int[2][k];
        boolean[][] wasRem = new boolean[2][k];

        int cur = 1, prev = 0;

        for (int num : nums) {
            for (int r = 0; r < k; r++) {
                if (wasRem[prev][r]) {

                    sumRem[cur][r] = Math.max(sumRem[cur][r], sumRem[prev][r]);
                    wasRem[cur][r] = true;

                    int sum = sumRem[prev][r] + num;
                    int rem = (r + num) % k;
                    if (!wasRem[cur][rem] || sum > sumRem[cur][rem]) {
                        sumRem[cur][rem] = sum;
                        wasRem[cur][rem] = true;
                    }
                }
            }

            if (!wasRem[cur][num % k] || num > sumRem[cur][num % k]) {
                sumRem[cur][num % k] = num;
                wasRem[cur][num % k] = true;
            }

            cur ^= 1;
            prev ^= 1;
        }

        return sumRem[prev][0];
    }
}
