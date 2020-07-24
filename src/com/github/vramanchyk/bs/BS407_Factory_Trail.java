package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS407_Factory_Trail {

    public int solve(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n / 5;
            n /= 5;
        }

        return answer;
    }
}
