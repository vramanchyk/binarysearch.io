package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/9/20.
 */
public class BS232_Making_Change_Sequel {

    private final int INF = Integer.MAX_VALUE;

    public int solve(int[] denominations, int amount) {

        final int[] counts = new int[amount + 1];
        counts[0] = 1;

        for (int idx = 1; idx <= amount; idx++) {
            counts[idx] = INF;

            for (int coin : denominations) {
                if (idx - coin >= 0 && counts[idx - coin] != INF) {
                    counts[idx] = Math.min(counts[idx], counts[idx - coin] + 1);
                }
            }
        }

        return counts[amount] == INF ? -1 : counts[amount] - 1;
    }
}
