package com.github.vramanchyk.bs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Vitali Ramanchyk on 8/28/20.
 */
public class BS255_Fair_Pay {

    public int solve(int[] ratings) {

        if (ratings.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> ratings[a]));

        int[] pay = new int[ratings.length];

        for (int index = 0; index < ratings.length; index++) {
            queue.add(index);
            pay[index] = 1;
        }

        int totalPay = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            totalPay += pay[idx];

            if (idx - 1 >= 0 && ratings[idx - 1] > ratings[idx]) {
                pay[idx - 1] = Math.max(pay[idx - 1], pay[idx] + 1);
            }

            if (idx + 1 < ratings.length && ratings[idx + 1] > ratings[idx]) {
                pay[idx + 1] = Math.max(pay[idx + 1], pay[idx] + 1);
            }
        }

        return totalPay;
    }
}
