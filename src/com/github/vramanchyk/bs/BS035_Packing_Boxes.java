package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS035_Packing_Boxes {

    private static class Pair {

        final int count;

        final int value;

        Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public int[][] solve(int[] nums) {
        if (nums.length == 0) {
            return new int[0][];
        }

        final List<Pair> pairs = new ArrayList<>();

        int last = 0;
        int count = 0;

        for (int index = 0; index < nums.length; index++) {
            if (index == 0 || nums[index - 1] != nums[index]) {
                if (count > 0) {
                    pairs.add(new Pair(nums[index - 1], count));
                    count = 0;
                }
            }

            last = nums[index];
            count++;
        }

        if (count > 0) {
            pairs.add(new Pair(last, count));
        }

        int[][] result = new int[pairs.size()][];
        for (int index = 0; index < pairs.size(); index++) {
            Pair pair = pairs.get(index);
            int[] sub = new int[pair.count];
            for (int cnt = 0; cnt < pair.count; cnt++) {
                sub[cnt] = pair.value;
            }

            result[index] = sub;
        }

        return result;
    }
}
