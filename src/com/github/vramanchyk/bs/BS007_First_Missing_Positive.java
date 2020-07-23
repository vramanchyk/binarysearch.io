package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS007_First_Missing_Positive {

    public int solve(int[] nums) {

        Arrays.sort(nums);

        int cursor = 0;
        while (cursor < nums.length && nums[cursor] <= 0) {
            cursor++;
        }

        if (cursor >= nums.length) {
            return 1;
        }

        if (cursor > 0 && nums[cursor] - 1 > 0 && nums[cursor] - 1 > nums[cursor - 1]) {
            return nums[cursor] - 1;
        }

        for (int index = cursor + 1; index < nums.length; index++) {
            if (nums[index - 1] + 1 != nums[index]) {
                return nums[index - 1] + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }
}