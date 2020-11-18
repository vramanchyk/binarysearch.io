package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Vitali Ramanchyk on 11/17/20.
 */
public class BS764_Minimum_Stack {

    private final Deque<Integer> stack = new ArrayDeque<>();

    private final Deque<Integer> min = new ArrayDeque<>();

    public BS764_Minimum_Stack() {

    }

    public void append(int val) {
        stack.push(val);
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
    }

    public int peek() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

    public int pop() {
        int val = stack.pop();
        if (min.peek() == val) {
            min.pop();
        }
        return val;
    }
}
