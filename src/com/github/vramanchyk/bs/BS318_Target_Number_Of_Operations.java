package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/10/20.
 */
public class BS318_Target_Number_Of_Operations {

    public int solve(int start, int end) {
        int count = 0;

        while (start < end) {
            if (end % 2 == 1) {
                end--;
                count++;
            } else if (start * 2 <= end) {
                end /= 2;
                count++;
            } else {
                count += end - start;
                end = start;
            }
        }

        return count;
    }
}
