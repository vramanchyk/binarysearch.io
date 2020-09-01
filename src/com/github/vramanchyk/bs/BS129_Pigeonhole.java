package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/1/20.
 */
public class BS129_Pigeonhole {

    public int solve(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int targetXor = 0;
        for (int i = 1; i < nums.length; i++) {
            targetXor ^= i;
        }

        for (int num : nums) {
            if ((xor ^ num) == targetXor) {
                return num;
            }
        }

        return -1;
    }
}
