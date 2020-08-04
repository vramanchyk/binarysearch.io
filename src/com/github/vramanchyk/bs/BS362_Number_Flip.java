package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/4/20.
 */
public class BS362_Number_Flip {

    private int rev(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }

        return res;
    }

    public int solve(int n) {
        int rev = rev(n);

        int answer = 0;
        boolean flip = false;
        while (rev > 0) {
            int dig = rev % 10;
            if (dig != 3 && !flip) {
                dig = 3;
                flip = true;
            }

            answer = answer * 10 + dig;
            rev /= 10;
        }

        return answer;
    }
}
