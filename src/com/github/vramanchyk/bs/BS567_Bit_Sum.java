package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS567_Bit_Sum {

    private final int MOD = 1_000_000_007;

    public int solve(int[] nums, int k) {

        for (int bit = 0; bit < 32; bit++) {

            for (int index = 0; index < nums.length; index++) {
                if (((nums[index] >> bit) & 1) == 0) {
                    nums[index] |= (1 << bit);
                    if (--k == 0) {
                        break;
                    }
                }
            }

            if (k == 0) {
                break;
            }
        }

        int sum = 0;
        for (int num : nums) {
            sum = (sum + (num % MOD)) % MOD;
        }

        return sum;
    }
}
