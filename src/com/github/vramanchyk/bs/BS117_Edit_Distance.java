package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS117_Edit_Distance {

    public int solve(String a, String b) {

        final int n = a.length();
        final int m = b.length();

        int[][] dist = new int[2][m + 1];

        int cur = 0;
        int prev = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dist[cur][j] = j;
                } else if (j == 0) {
                    dist[cur][j] = i;
                } else {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dist[cur][j] = dist[prev][j - 1];
                    } else {
                        dist[cur][j] = dist[prev][j - 1] + 1;
                    }

                    int min = Math.min(dist[prev][j], dist[cur][j - 1]) + 1;

                    if (min < dist[cur][j]) {
                        dist[cur][j] = min;
                    }
                }
            }

            cur ^= 1;
            prev ^= 1;
        }

        return dist[prev][m];
    }
}
