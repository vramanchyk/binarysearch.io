package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS035_Balanced_Brackets_Sequel {

    public boolean solve(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char last = stack.pop();
                if (
                        (last != '(' && ch == ')') ||
                                (last != '[' && ch == ']') ||
                                (last != '{' && ch == '}')) {

                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
