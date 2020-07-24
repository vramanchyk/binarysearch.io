package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS511_Count_Of_Sublists {

    public int solve(int[] nums) {
        final Map<Integer, Integer> counts = new HashMap<>();

        int answer = 0;
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0);
            answer += count + 1;
            counts.put(num, count + 1);
        }

        return answer;
    }
}
