package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS675_Repeated_Deletion_Sequel {

    public String solve(String s, int k) {

        if (k == 1) {
            return "";
        }

        final Deque<int[]> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (stack.isEmpty() || stack.peek()[0] != ch) {
                stack.push(new int[]{ch, 1});
            } else {
                if (++stack.peek()[1] == k) {
                    stack.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            int[] value = stack.pop();
            while (value[1]-- > 0) {
                result.append((char) value[0]);
            }
        }

        return result.reverse().toString();
    }
}
