package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS527_Skydivers {

    private boolean check(int target, int k, int[] nums) {

        int curSum = 0;
        int count = 0;

        for (int num : nums) {
            if (num > target) {
                return false;
            }

            if (curSum + num > target) {
                curSum = 0;
                count++;

                if (count > k) {
                    return false;
                }
            }

            curSum += num;
        }

        return k >= count + (curSum == 0 ? 0 : 1);
    }

    public int solve(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int l = 0, r = sum;
        while (l <= r) {
            int m = (l + r) / 2;
            if (check(m, k, nums)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
