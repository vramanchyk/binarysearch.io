package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS496_Lone_Integer {

    public int solve(int[] nums) {

        int result = 0;
        for (int bit = 0; bit < 32; bit++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >> bit) & 1;
            }

            if (cnt % 3 == 1) {
                result |= (1 << bit);
            }
        }

        return result;
    }
}
