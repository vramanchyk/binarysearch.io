package com.github.vramanchyk.bs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS345_Bounce {

    public boolean solve(int[] nums, int k) {

        if (nums.length == 0 || k == nums.length - 1) {
            return true;
        }

        final int n = nums.length;
        final boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        visited[k] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur + nums[cur] == n - 1) {
                return true;
            }

            int jump1 = cur + nums[cur];
            int jump2 = cur - nums[cur];

            if (jump1 < n && !visited[jump1]) {
                visited[jump1] = true;
                queue.add(jump1);
            }

            if (jump2 >= 0 && !visited[jump2]) {
                visited[jump2] = true;
                queue.add(jump2);
            }
        }

        return false;
    }
}
