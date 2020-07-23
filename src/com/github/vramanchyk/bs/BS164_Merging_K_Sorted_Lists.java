package com.github.vramanchyk.bs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS164_Merging_K_Sorted_Lists {

    private static class Pointer {

        final int val;

        final int list;

        Pointer(int val, int list) {
            this.val = val;
            this.list = list;
        }
    }

    public int[] solve(int[][] lists) {

        final PriorityQueue<Pointer> queue = new PriorityQueue<Pointer>(
                Comparator.comparingInt(p -> p.val)
        );

        int totalLength = 0;
        int[] cursors = new int[lists.length];

        for (int index = 0; index < lists.length; index++) {
            final int[] list = lists[index];
            if (list.length > 0) {
                cursors[index] = 1;
                queue.add(new Pointer(list[0], index));
                totalLength += list.length;
            }
        }

        final int[] result = new int[totalLength];
        int cursor = 0;

        while (!queue.isEmpty()) {
            final Pointer p = queue.poll();
            result[cursor++] = p.val;
            if (cursors[p.list] < lists[p.list].length) {
                queue.add(new Pointer(lists[p.list][cursors[p.list]++], p.list));
            }
        }

        return result;
    }
}
