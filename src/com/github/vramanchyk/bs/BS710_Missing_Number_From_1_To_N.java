package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/1/20.
 */
public class BS710_Missing_Number_From_1_To_N {

    public int[] solve(int[] nums) {
        int duplicates = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            } else {
                duplicates++;
            }
        }

        int cursor = 0;
        final int[] result = new int[duplicates];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[cursor++] = i + 1;
            }
        }

        return result;
    }
}
