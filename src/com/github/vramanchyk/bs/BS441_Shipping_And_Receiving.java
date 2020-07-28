package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS441_Shipping_And_Receiving {

    private final int INF = Integer.MAX_VALUE;

    public int solve(int[][] ports, int[][] shipments) {
        final int n = ports.length;

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {

            Arrays.fill(dist[i], INF);

            for (int port : ports[i]) {
                dist[i][port] = 1;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int answer = 0;
        for (int[] ship : shipments) {
            if (dist[ship[0]][ship[1]] != INF) {
                answer += dist[ship[0]][ship[1]];
            }
        }

        return answer;
    }
}
