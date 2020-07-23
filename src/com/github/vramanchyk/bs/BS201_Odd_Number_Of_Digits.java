package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS201_Odd_Number_Of_Digits {

    private boolean isOdd(int value) {
        int cnt = 0;

        while (value > 0) {
            cnt++;
            value /= 10;
        }

        return cnt % 2 == 1;
    }

    public int solve(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            if (isOdd(num)) {
                ans++;
            }
        }

        return ans;
    }
}
