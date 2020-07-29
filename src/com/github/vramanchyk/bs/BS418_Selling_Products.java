package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS418_Selling_Products {

    public int solve(int[] items, int n) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : items) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(counts.values());
        list.sort(Comparator.reverseOrder());

        for (int index = list.size() - 1; index >= 0; index--) {
            if (n == list.get(index)) {
                return index;
            }
            if (n < list.get(index)) {
                return index + 1;
            }

            n -= list.get(index);
        }

        return 0;
    }
}
