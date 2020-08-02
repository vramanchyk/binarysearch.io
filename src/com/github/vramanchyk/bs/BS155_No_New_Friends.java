package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/2/20.
 */
public class BS155_No_New_Friends {

    public boolean solve(int n, int[][] friends) {
        boolean[] hasFriends = new boolean[n];

        for (int[] tuple : friends) {
            hasFriends[tuple[0]] = hasFriends[tuple[1]] = true;
        }

        for (int index = 0; index < n; index++) {
            if (!hasFriends[index]) {
                return false;
            }
        }

        return true;
    }
}
