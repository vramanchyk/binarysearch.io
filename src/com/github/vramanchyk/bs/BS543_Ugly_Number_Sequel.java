package com.github.vramanchyk.bs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 8/2/20.
 */
public class BS543_Ugly_Number_Sequel {

    private static final int INF = 100_000_000;

    private void add(int num, int n, Set<Integer> visited, PriorityQueue<Integer> queue) {
        if (visited.add(num)) {
            queue.add(num);
            if (queue.size() > n) {
                queue.poll();
            }
        }
    }

    public int solve(int n) {
        if (n == 0) {
            return 1;
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(1);

        n++;
        for (int t2 = 2; t2 <= INF; t2 *= 2) {
            for (int t3 = 3; t3 <= INF; t3 *= 3) {
                for (int t5 = 5; t5 <= INF; t5 *= 5) {
                    add(t2, n, visited, queue);
                    add(t3, n, visited, queue);
                    add(t5, n, visited, queue);
                    if ((long) t2 * t3 <= INF) {
                        add(t2 * t3, n, visited, queue);

                        if ((long) t2 * t3 * t5 <= INF) {
                            add(t2 * t3 * t5, n, visited, queue);
                        }
                    }
                    if ((long) t2 * t5 <= INF) {
                        add(t2 * t5, n, visited, queue);
                    }
                    if ((long) t3 * t5 <= INF) {
                        add(t3 * t5, n, visited, queue);
                    }
                }
            }
        }

        return queue.poll();
    }
}
