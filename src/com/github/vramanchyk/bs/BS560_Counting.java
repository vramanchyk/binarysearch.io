package com.github.vramanchyk.bs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS560_Counting {

    public int solve(int[] nums) {
        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            visited.add(num);
        }

        int count = 0;
        for (int num : nums) {
            if (visited.contains(num + 1)) {
                count++;
            }
        }

        return count;
    }
}
