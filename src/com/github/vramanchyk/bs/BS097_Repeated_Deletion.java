package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS097_Repeated_Deletion {

    public String solve(String s) {

        final Deque<int[]> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            int ich = ch - 'a';

            while (!stack.isEmpty() && (ich != stack.peek()[0] && stack.peek()[1] > 1)) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek()[0] != ich) {
                stack.push(new int[]{ich, 0});
            }

            stack.peek()[1]++;
        }

        while (!stack.isEmpty() && stack.peek()[1] > 1) {
            stack.pop();
        }

        StringBuilder bld = new StringBuilder();
        while (!stack.isEmpty()) {
            bld.append((char) (stack.pop()[0] + 'a'));
        }

        return bld.reverse().toString();
    }
}
