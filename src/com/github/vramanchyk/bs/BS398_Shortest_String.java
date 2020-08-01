package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Vitali Ramanchyk on 7/31/20.
 */
public class BS398_Shortest_String {

    public int solve(String s) {
        final Deque<Integer> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() != (ch - '0')) {
                stack.pop();
            } else {
                stack.push(ch - '0');
            }
        }

        return stack.size();
    }
}
