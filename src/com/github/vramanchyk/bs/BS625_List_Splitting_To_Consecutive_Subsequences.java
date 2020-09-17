package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Vitali Ramanchyk on 9/17/20.
 */
public class BS625_List_Splitting_To_Consecutive_Subsequences {

    public boolean solve(int[] nums) {
        final Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int num : nums) {

            int size = 0;
            PriorityQueue<Integer> q = map.get(num - 1);

            if (q != null && !q.isEmpty()) {
                size = q.poll();
            }

            map.computeIfAbsent(num, t -> new PriorityQueue<>()).add(size + 1);
        }

        for (PriorityQueue<Integer> q : map.values()) {
            while (!q.isEmpty()) {
                if (q.poll() < 3) {
                    return false;
                }
            }
        }

        return true;
    }
}
