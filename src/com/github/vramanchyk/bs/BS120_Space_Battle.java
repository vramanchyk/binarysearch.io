package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS120_Space_Battle {

    public int[] solve(int[] nums) {

        final Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums) {
            if (num >= 0) {
                stack.push(num);
            } else {

                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(num);
                } else if (stack.peek() == -num) {
                    stack.pop();
                }
            }
        }

        final int[] result = new int[stack.size()];
        int cursor = stack.size() - 1;

        while (!stack.isEmpty()) {
            result[cursor--] = stack.pop();
        }

        return result;
    }
}
