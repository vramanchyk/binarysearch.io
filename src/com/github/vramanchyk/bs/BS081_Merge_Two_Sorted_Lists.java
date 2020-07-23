package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS081_Merge_Two_Sorted_Lists {

    public int[] solve(int[] lst0, int[] lst1) {
        final int len0 = lst0.length;
        final int len1 = lst1.length;

        int[] result = new int[len0 + len1];

        int cursor0 = 0, cursor1 = 0, cursor = 0;
        while (cursor0 < len0 && cursor1 < len1) {
            if (lst0[cursor0] < lst1[cursor1]) {
                result[cursor++] = lst0[cursor0++];
            } else {
                result[cursor++] = lst1[cursor1++];
            }
        }

        while (cursor0 < len0) {
            result[cursor++] = lst0[cursor0++];
        }

        while (cursor1 < len1) {
            result[cursor++] = lst0[cursor1++];
        }

        return result;
    }
}
