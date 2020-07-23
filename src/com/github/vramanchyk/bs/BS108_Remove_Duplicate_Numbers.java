package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS108_Remove_Duplicate_Numbers {

    public int[] solve(int[] nums) {
        Map<Integer, Integer> visited = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            visited.put(num, visited.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (visited.get(num) == 1) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
