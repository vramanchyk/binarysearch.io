package com.github.vramanchyk.bs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS462_Cell_Fusion {

    public int solve(int[] cells) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int cell : cells) {
            queue.add(cell);
        }

        while (queue.size() > 1) {
            int cell1 = queue.poll();
            int cell2 = queue.poll();

            if (cell1 != cell2) {
                queue.add((cell1 + cell2) / 3);
            }
        }

        return queue.size() == 0 ? -1 : queue.poll();
    }
}
