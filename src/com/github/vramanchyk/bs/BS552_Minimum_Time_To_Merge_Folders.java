package com.github.vramanchyk.bs;

import java.util.PriorityQueue;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS552_Minimum_Time_To_Merge_Folders {

    public int solve(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        int answer = 0;
        while (queue.size() > 1) {
            int v1 = queue.poll();
            int v2 = queue.poll();
            answer += v1 + v2;
            queue.add(v1 + v2);
        }

        return answer;
    }
}
