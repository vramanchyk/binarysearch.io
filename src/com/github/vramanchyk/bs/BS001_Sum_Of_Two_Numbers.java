package com.github.vramanchyk.bs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS001_Sum_Of_Two_Numbers {

    public boolean solve(int[] nums, int k) {

        final Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(k - num)) {
                return true;
            }

            visited.add(num);
        }

        return false;
    }
}
