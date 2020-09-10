package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 9/10/20.
 */
public class BS467_Longest_Path_In_A_Graph {

    private int traverse(int cur, int[][] g, int[] max, boolean[] visited) {

        if (g[cur].length == 0) {
            return 1;
        }

        if (max[cur] != -1) {
            return max[cur];
        }

        int path = 0;
        for (int target : g[cur]) {
            if (!visited[target]) {
                visited[target] = true;
                path = Math.max(path, traverse(target, g, max, visited));
                visited[target] = false;
            }
        }

        return max[cur] = path + 1;
    }

    public int solve(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return 0;
        }

        final int n = graph.length;
        final int[] max = new int[n];
        final boolean[] visited = new boolean[n];

        Arrays.fill(max, -1);

        int maxPath = 0;

        for (int node = 0; node < n; node++) {
            visited[node] = true;
            maxPath = Math.max(maxPath, traverse(node, graph, max, visited));
            visited[node] = false;
        }

        return maxPath - 1;
    }
}
