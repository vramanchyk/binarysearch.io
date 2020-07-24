package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS279_Sublist_Sum {

    public boolean solve(int[] nums) {

        if (nums.length < 2) {
            return false;
        }

        int sum = 0;
        int totalSum = 0;
        Integer maxSum = null;

        for (int num : nums) {
            totalSum += num;
            sum = Math.max(sum + num, num);
            maxSum = maxSum == null ? sum : Math.max(maxSum, sum);
        }

        return maxSum > totalSum;
    }
}
