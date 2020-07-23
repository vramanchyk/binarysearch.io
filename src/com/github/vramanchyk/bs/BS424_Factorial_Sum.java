package com.github.vramanchyk.bs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS424_Factorial_Sum {

    public boolean solve(int n) {

        if (n == 1) {
            return true;
        }

        Set<Long> visited = new HashSet<>();
        visited.add(0L);

        long factorial = 1;

        for (int idx = 1; factorial <= n / idx; idx++) {
            factorial *= idx;

            Set<Long> update = new HashSet<>();

            for (Long number : visited) {
                update.add(number);

                if (number + factorial == n) {
                    return true;
                }
                if (number + factorial < n) {
                    update.add(number + factorial);
                }
            }

            visited = update;
        }

        return false;
    }
}
