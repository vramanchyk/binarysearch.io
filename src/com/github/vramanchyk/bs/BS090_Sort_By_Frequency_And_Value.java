package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/22/20.
 */
public class BS090_Sort_By_Frequency_And_Value {

    public int[] solve(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();

        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqs.entrySet());

        list.sort((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue());
            if (cmp != 0) {
                return cmp;
            }

            return Integer.compare(b.getKey(), a.getKey());
        });

        int cur = 0;
        int[] result = new int[nums.length];

        for (Map.Entry<Integer, Integer> en : list) {
            for (int freq = 0; freq < en.getValue(); freq++) {
                result[cur++] = en.getKey();
            }
        }

        return result;
    }
}
