package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS302_Target_Number_Of_Operations_Sequel {

    public int solve(int start, int end) {
        int count = 0;
        while (start < end) {
            if (end % 2 == 1) {
                end++;
                count++;
            } else {
                end /= 2;
                count++;
            }
        }

        count += start - end;

        return count;
    }
}
