package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS578_Forest_Detection {

    private int getParent(int v, Map<Integer, Integer> parents) {
        if (v == parents.get(v)) {
            return v;
        }

        int par = getParent(parents.get(v), parents);
        parents.put(v, par);
        return par;
    }

    private void merge(int x, int y, Map<Integer, Integer> w, Map<Integer, Integer> p) {
        int wx = w.getOrDefault(x, 0);
        int wy = w.getOrDefault(y, 0);

        if (wx < wy) {
            p.put(x, y);
        } else if (wy < wx) {
            p.put(y, x);
        } else {
            p.put(x, y);
            w.put(y, wy + 1);
        }
    }

    public boolean solve(int[][] edges) {

        Map<Integer, Integer> w = new HashMap<>();
        Map<Integer, Integer> parents = new HashMap<>();

        for (int[] edge : edges) {
            parents.putIfAbsent(edge[0], edge[0]);
            parents.putIfAbsent(edge[1], edge[1]);
        }

        for (int[] edge : edges) {
            int p0 = getParent(edge[0], parents);
            int p1 = getParent(edge[1], parents);

            if (p0 == p1) {
                return false;
            }

            merge(p0, p1, w, parents);
        }

        return true;
    }
}
