package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS221_Direct_Closure {

    private List<Integer> find(int k, boolean[] visited, int[][] graph) {
        final List<Integer> result = new ArrayList<>();
        final Deque<Integer> queue = new ArrayDeque<>();

        queue.add(k);
        visited[k] = true;
        result.add(k);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int t : graph[cur]) {
                if (!visited[t]) {
                    visited[t] = true;
                    result.add(t);
                    queue.add(t);
                }
            }
        }

        return result;
    }

    private void update(int n, List<Integer> list, int[][] m) {
        for (int i = 0; i < list.size(); i++) {
            final int ii = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                final int jj = list.get(j);
                m[ii][jj] = m[jj][ii] = 1;
            }
        }
    }

    public int[][] solve(int[][] graph) {
        final int n = graph.length;
        final int[][] result = new int[n][n];
        final boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            result[i][i] = 1;

            if (!visited[i]) {
                List<Integer> groups = find(i, visited, graph);
                update(n, groups, result);
            }
        }

        return result;
    }
}
