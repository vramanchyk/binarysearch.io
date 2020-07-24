package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS539_Stepping_Numbers {

    private final int MOD = 1_000_000_007;

    public int solve(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 10;
        }

        int[][] counts = new int[2][10];
        for (int dig = 0; dig < 10; dig++) {
            counts[0][dig] = 1;
        }

        int prev = 0;
        int cur = 1;

        for (int i = 2; i <= n; i++) {
            for (int dig = 0; dig < 10; dig++) {
                counts[cur][dig] = 0;
                if (dig > 0) {
                    counts[cur][dig] = (counts[cur][dig] + counts[prev][dig - 1]) % MOD;
                }
                if (dig < 9) {
                    counts[cur][dig] = (counts[cur][dig] + counts[prev][dig + 1]) % MOD;
                }
            }

            cur ^= 1;
            prev ^= 1;
        }

        int answer = 0;
        for (int dig = 1; dig < 10; dig++) {
            answer = (answer + counts[prev][dig]) % MOD;
        }

        return answer;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            System.out.println(new BS539_Stepping_Numbers().solve(i));
        }
    }
}
