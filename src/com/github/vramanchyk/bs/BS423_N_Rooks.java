package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/4/20.
 */
public class BS423_N_Rooks {

    public int solve(int n) {

        int answer = 1;
        while (n > 0) {
            answer *= n--;
        }

        return answer;
    }
}
