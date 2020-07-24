package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS389_All_Sublist_Sum_Target {

    public int solve(int[] nums, int target) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int sum = 0;
        int answer = 0;
        for (int num : nums) {
            sum += num;
            answer += count.getOrDefault(sum - target, 0);
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        new BS389_All_Sublist_Sum_Target().solve(new int[] {2, 0, 2}, 2);
    }
}
