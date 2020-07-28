package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS167_Largest_Sublist_Sum {

    public int solve(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int curSum = 0;

        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
