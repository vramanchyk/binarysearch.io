package com.github.vramanchyk.bs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS342_Equal_Piles {

    public int solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int min = nums[0];
        final Map<Integer, Integer> counts = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0);
            if (count == 0) {
                queue.add(num);
            }
            counts.put(num, count + 1);
        }

        int answer = 0;
        while (queue.size() > 1) {
            final int count = counts.get(queue.poll());
            answer += count * queue.size();
        }

        return answer;
    }
}
