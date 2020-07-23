package com.github.vramanchyk.bs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS176_Kth_Smallest_Element {

    public int solve(int[] nums, int k) {

        final PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            if (queue.size() <= k) {
                queue.add(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }

        return queue.peek();
    }
}
