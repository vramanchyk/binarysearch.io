package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 9/11/20.
 */
public class BS114_Longest_Zero_Sublist_Sum {

    public int solve(int[] nums) {

        final Map<Integer, Integer> sums = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        sums.put(0, -1);

        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];

            Integer offset = sums.get(sum);
            if (offset != null) {
                maxLen = Math.max(maxLen, index - offset);
            } else {
                sums.put(sum, index);
            }
        }

        return maxLen;
    }
}
