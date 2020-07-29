package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS156_Friend_Groups {

    private int getParent(int v, int[] parents) {
        if (v == parents[v]) {
            return v;
        }

        return parents[v] = getParent(parents[v], parents);
    }

    private void merge(int x, int y, int[] parents, int[] w) {
        if (w[x] < w[y]) {
            parents[x] = y;
        } else if (w[y] < w[x]) {
            parents[y] = x;
        } else {
            parents[x] = y;
            w[y]++;
        }
    }

    public int solve(int[][] friends) {
        final int n = friends.length;

        int[] parents = new int[n];
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int index = 0; index < n; index++) {
            final int[] edges = friends[index];
            for (int v : edges) {
                int px = getParent(index, parents);
                int py = getParent(v, parents);
                if (px != py) {
                    merge(px, py, parents, w);
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
