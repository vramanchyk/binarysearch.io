package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS254_Uber_Pool {

    public boolean solve(int[][] trips, int capacity) {

        List<int[]> events = new ArrayList<>();

        for (int[] trip : trips) {
            if (trip[2] != 0) {
                events.add(new int[]{trip[0], trip[2]});
                events.add(new int[]{trip[1], -trip[2]});
            }
        }

        events.sort(Comparator.comparingInt(a -> a[0]));

        int cursor = 0;
        int passengers = 0;

        while (cursor < events.size()) {
            int tmp = cursor;

            while (tmp < events.size() && events.get(cursor) == events.get(tmp)) {
                passengers += events.get(tmp)[1];
                tmp++;
            }

            if (passengers > capacity) {
                return false;
            }

            cursor = tmp;
        }

        return true;
    }
}
