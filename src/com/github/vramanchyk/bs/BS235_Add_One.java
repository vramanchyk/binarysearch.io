package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS235_Add_One {

    public int[] solve(int[] nums) {

        int mod = 0;
        int len = nums.length;

        int[] add = new int[len + 1];
        nums[len - 1]++;

        for (int index = len - 1; index >= 0; index--) {
            add[index + 1] = (nums[index] + mod) % 10;
            mod = (nums[index] + mod) / 10;
        }

        add[0] = mod;

        if (add[0] == 0) {
            return Arrays.copyOfRange(add, 1, len + 1);
        }

        return add;
    }
}
