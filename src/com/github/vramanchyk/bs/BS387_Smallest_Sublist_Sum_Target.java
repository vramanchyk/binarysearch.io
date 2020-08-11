package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/10/20.
 */
public class BS387_Smallest_Sublist_Sum_Target {

    public int solve(int[] nums, int target) {
        int sum = 0;
        int l = 0, r = 0;

        int ans = -1;
        while (r < nums.length) {

            while (r < nums.length && sum < target) {
                sum += nums[r];
                r++;
            }

            if (sum < target) {
                break;
            }

            while (l <= r && sum - nums[l] >= target) {
                sum -= nums[l++];
            }

            if (ans == -1 || ans > r - l) {
                ans = r - l;
            }

            sum -= nums[l++];
        }

        return ans;
    }
}
