package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 9/4/20.
 */
public class BS497_Quadruple_Rainbow {

    public int solve(int[] a, int[] b, int[] c, int[] d, int target) {
        Map<Integer, Integer> bcCounts = new HashMap<>();

        for (int bNum : b) {
            for (int cNum : c) {
                final int sum = bNum + cNum;
                bcCounts.put(sum, bcCounts.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int aNum : a) {
            for (int dNum : d) {
                count += bcCounts.getOrDefault(target - aNum - dNum, 0);
            }
        }

        return count;
    }
}
