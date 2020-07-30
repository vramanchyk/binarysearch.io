package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/30/20.
 */
public class BS580_Group_Points {

    private int getParent(int v, int[] parents) {
        if (v == parents[v]) {
            return v;
        }

        return parents[v] = getParent(parents[v], parents);
    }

    private void merge(int x, int y, int[] w, int[] parents) {
        x = getParent(x, parents);
        y = getParent(y, parents);

        if (x == y) {
            return;
        }

        if (w[x] < w[y]) {
            parents[x] = y;
        } else if (w[y] < w[x]) {
            parents[y] = x;
        } else {
            parents[x] = y;
            w[y]++;
        }
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public int solve(int[][] points, int k) {
        final int n = points.length;

        final int[] parents = new int[n];
        final int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int[] pointA = points[i];

            for (int j = 0; j < i; j++) {
                int[] pointB = points[j];
                if (dist(pointA[0], pointA[1], pointB[0], pointB[1]) <= k * k) {
                    merge(i, j, w, parents);
                }
            }
        }

        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (i == getParent(i, parents)) {
                groups++;
            }
        }

        return groups;
    }
}
