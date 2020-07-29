package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS092_Rain_Catcher {

    public int solve(int[] nums) {
        final int n = nums.length;

        int[] l = new int[n];
        int[] r = new int[n];

        for (int i = 0; i < n; i++) {
            l[i] = Math.max(nums[i], i > 0 ? l[i - 1] : 0);
            r[n - i - 1] = Math.max(nums[n - i - 1], i > 0 ? r[n - i] : 0);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int ls = i > 0 ? l[i - 1] : 0;
            int rs = i + 1 < n ? r[i + 1] : 0;

            int m = Math.min(ls, rs);
            if (nums[i] < m) {
                result += m - nums[i];
            }
        }

        return result;
    }
}
