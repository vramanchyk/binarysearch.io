package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 * <p>
 * https://binarysearch.io/problems/All-Sublists-Sum
 */
public class BS283_All_Sublists_Sum {

    private final int MOD = 1_000_000_007;

    private int mul(int a, int b) {
        int result = 0;

        a %= MOD;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result + a) % MOD;
            }

            a = (2 * a) % MOD;
            b /= 2;
        }

        return result;
    }

    public int solve(int[] nums) {

        int answer = 0;
        for (int index = 0; index < nums.length; index++) {
            int left = index + 1;
            int right = nums.length - index;
            answer = (answer + mul(nums[index], left * right)) % MOD;
        }

        return answer;
    }
}
