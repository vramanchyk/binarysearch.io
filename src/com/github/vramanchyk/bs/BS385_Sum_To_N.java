package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS385_Sum_To_N {

    public int solve(int s) {
        int answer = 0;

        for (int n = 1; n <= s; n++) {
            if (2 * s / n + 1 - n < 0) {
                break;
            }
            if ((2 * s) % n == 0) {
                int k = 2 * s / n + 1 - n;
                if (k % 2 == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
