package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS300_List_Calculator {

    public int[] solve(int[] nums, String op, int val) {

        for (int index = 0; index < nums.length; index++) {
            if ("+".equals(op)) {
                nums[index] += val;
            } else if ("-".equals(op)) {
                nums[index] -= val;
            } else if ("*".equals(op)) {
                nums[index] *= val;
            } else {
                nums[index] /= val;
            }
        }

        return nums;
    }
}
