package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/2/20.
 */
public class BS032_First_Missing_Positive2 {

    public int solve(int[] arr) {
        int expected = 1;
        int index = 0;

        while (index < arr.length && arr[index] < expected) {
            index++;
        }

        while (index < arr.length && arr[index] == expected) {
            expected++;
            index++;
        }

        return expected;
    }
}
