package com.github.vramanchyk.bs;

import java.util.PriorityQueue;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS381_One_Integer {

    public int solve(int[] nums) {

        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        int ans = 0;
        while (queue.size() != 1) {
            int v1 = queue.poll();
            int v2 = queue.poll();
            queue.add(v1 + v2);
            ans += v1 + v2;
        }

        return ans;
    }
}
