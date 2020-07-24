package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS547_K_Distinct_Window {

    public int[] solve(int[] nums, int k) {

        if (k > nums.length) {
            return new int[]{};
        }

        int[] result = new int[nums.length - k + 1];
        Map<Integer, Integer> counts = new HashMap<>();

        for (int index = 0; index < k; index++) {
            counts.put(nums[index], counts.getOrDefault(nums[index], 0) + 1);
        }

        result[0] = counts.size();

        for (int index = k; index < nums.length; index++) {
            counts.put(nums[index], counts.getOrDefault(nums[index], 0) + 1);
            int count = counts.get(nums[index - k]);
            if (count == 1) {
                counts.remove(nums[index - k]);
            } else {
                counts.put(nums[index - k], count - 1);
            }
            result[index - k + 1] = counts.size();
        }

        return result;
    }
}
