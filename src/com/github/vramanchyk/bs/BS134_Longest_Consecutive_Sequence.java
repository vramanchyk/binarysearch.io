package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS134_Longest_Consecutive_Sequence {

    public int solve(int[] nums) {
        Arrays.sort(nums);

        int cursor = 0;
        int result = 0;

        while (cursor < nums.length) {

            int right = cursor;
            int duplicates = 0;

            while (right + 1 < nums.length && (nums[right + 1] == nums[right] + 1 || nums[right + 1] == nums[right])) {

                if (right + 1 < nums.length && nums[right + 1] == nums[right]) {
                    duplicates++;
                }

                right++;
            }

            result = Math.max(result, right - cursor + 1 - duplicates);
            cursor = right + 1;
        }

        return result;
    }
}
