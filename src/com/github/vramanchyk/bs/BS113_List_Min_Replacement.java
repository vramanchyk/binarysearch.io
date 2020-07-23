package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS113_List_Min_Replacement {

    public int[] solve(int[] nums) {

        if (nums.length == 1) {
            nums[0] = 0;
            return nums;
        }

        int min = nums[0];
        for (int index = 1; index < nums.length; index++) {
            int copy = nums[index];
            nums[index] = min;
            min = Math.min(min, copy);
        }

        nums[0] = 0;
        return nums;
    }
}
