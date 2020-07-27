package com.github.vramanchyk.bs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/27/20.
 */
public class BS314_Minimum_Spanning_Tree {

    private int getParent(int v, Map<Integer, Integer> parents) {
        if (v == parents.get(v)) {
            return v;
        }

        int parent = getParent(parents.get(v), parents);
        parents.put(v, parent);
        return parent;
    }

    private void merge(int x, int y, Map<Integer, Integer> parents, Map<Integer, Integer> w) {

        int wx = w.getOrDefault(x, 0);
        int wy = w.getOrDefault(y, 0);

        if (wx < wy) {
            parents.put(x, y);
        } else if (wy < wx) {
            parents.put(y, x);
        } else {
            parents.put(x, y);
            w.put(y, wy + 1);
        }
    }

    public boolean solve(int[][] edges, int a, int b) {

        final Map<Integer, Integer> parents = new HashMap<>();
        final Map<Integer, Integer> w = new HashMap<>();

        for (int[] edge : edges) {
            parents.putIfAbsent(edge[0], edge[0]);
            parents.putIfAbsent(edge[1], edge[1]);
        }

        int totalCount = parents.size();

        Arrays.sort(edges, Comparator.comparingInt(x -> x[2]));

        for (int[] edge : edges) {

            int px = getParent(edge[0], parents);
            int py = getParent(edge[1], parents);

            if (px != py) {
                if ((edge[0] == a && edge[1] == b) || (edge[1] == a && edge[0] == b)) {
                    return true;
                }

                merge(px, py, parents, w);
                if (--totalCount == 1) {
                    break;
                }
            }
        }

        return false;
    }
}
