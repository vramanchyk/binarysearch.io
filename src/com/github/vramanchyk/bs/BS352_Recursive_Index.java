package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/3/20.
 */
public class BS352_Recursive_Index {

    public int solve(int[] nums, int k) {
        int size = 0;
        while (k >= 0 && k < nums.length) {
            int t = nums[k];
            nums[k] = -1;
            k = t;
            size++;
        }

        return k < 0 ? -1 : size;
    }
}
