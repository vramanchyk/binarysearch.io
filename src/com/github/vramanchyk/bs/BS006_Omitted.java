package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS006_Omitted {

    public int[] solve(int[] nums) {
        final int n = nums.length;

        if (n == 1) {
            return new int[]{nums[0]};
        }

        final int[] r = new int[n];
        final int[] result = new int[n];

        r[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            r[i] = nums[i] * r[i + 1];
        }

        int current = 1;
        for (int i = 0; i < n; i++) {
            result[i] = current * (i + 1 < n ? r[i + 1] : 1);
            current *= nums[i];
        }

        return result;
    }
}
