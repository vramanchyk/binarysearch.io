package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 8/9/20.
 */
public class BS239_Reverse_Graph {

    public int[][] solve(int[][] graph) {
        final int n = graph.length;

        Map<Integer, List<Integer>> reverse = new HashMap<>();
        int index = 0;

        for (int idx = 0; idx < n; idx++) {
            reverse.put(idx, new ArrayList<>());
        }

        for (int[] nodes : graph) {

            for (int target : nodes) {
                reverse.get(target).add(index);
            }

            index++;
        }

        final int len = reverse.size();
        final int[][] result = new int[len][];

        for (index = 0; index < len; index++) {
            List<Integer> rev = reverse.get(index);
            result[index] = rev == null ? new int[]{} : rev.stream().mapToInt(t -> t).toArray();
        }

        return result;
    }
}
