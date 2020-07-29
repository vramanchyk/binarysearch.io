package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS551_Maximum_Sum_Removing_K {

    public int solve(int[] nums, int k) {

        if (k == 0) {
            return 0;
        }

        int n = nums.length;
        int[] left = new int[k];
        int[] right = new int[k];

        for (int i = 0; i < k; i++) {
            left[i] = (i > 0 ? left[i - 1] : 0) + nums[i];
            right[i] = (i > 0 ? right[i - 1] : 0) + nums[n - i - 1];
        }

        int max = Math.max(0, Math.max(left[k - 1], right[k - 1]));
        for (int i = 0; i < k; i++) {
            int sum = (i > 0 ? left[i - 1] : 0) + right[k - i - 1];
            max = Math.max(max, sum);
        }

        return max;
    }
}
