package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS716_Separate_People_Given_Dislikes {

    private boolean split(int cur, int[] color, Map<Integer, List<Integer>> g) {
        Queue<Integer> queue = new LinkedList<>();

        color[cur] = 1;
        queue.add(cur);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            List<Integer> enemies = g.get(cur);
            if (enemies != null) {
                for (int e : enemies) {
                    if (color[e] == 0) {
                        color[e] = color[cur] == 1 ? 2 : 1;
                        queue.add(e);
                    } else {
                        if (color[e] == color[cur]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean solve(int n, int[][] enemies) {
        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int[] pair : enemies) {
            g.computeIfAbsent(pair[0], v -> new LinkedList<>()).add(pair[1]);
            g.computeIfAbsent(pair[1], v -> new LinkedList<>()).add(pair[0]);
        }

        final int[] color = new int[n];

        for (int index = 0; index < n; index++) {
            if (color[index] == 0) {
                if (!split(index, color, g)) {
                    return false;
                }
            }
        }

        return true;
    }
}
