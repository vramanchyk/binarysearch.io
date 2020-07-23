package com.github.vramanchyk.bs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS174_Long_Distance {

    public int[] solve(int[] lst) {

        final int len = lst.length;
        final Integer[] positions = new Integer[len];

        for (int index = 0; index < len; index++) {
            positions[index] = index;
        }

        Arrays.sort(positions, Comparator.comparing(idx -> lst[idx]));

        final int[] result = new int[len];
        for (int index = 0; index < len; index++) {
            result[positions[index]] = index;
        }

        return result;
    }
}
