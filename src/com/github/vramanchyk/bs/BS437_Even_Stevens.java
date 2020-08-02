package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/1/20.
 */
public class BS437_Even_Stevens {

    public int[] solve(int[] nums) {
        int last = -1;

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] % 2 == 0) {
                if (last != -1) {

                    int tmp = nums[index];
                    nums[index] = nums[last];
                    nums[last] = tmp;
                    last = -1;

                } else {
                    last = index;
                }
            }
        }

        return nums;
    }
}
