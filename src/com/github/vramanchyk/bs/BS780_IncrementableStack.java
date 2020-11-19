package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 11/18/20.
 */
public class BS780_IncrementableStack {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final List<Integer> sums = new ArrayList<>();

    public BS780_IncrementableStack() {

    }

    public void append(int val) {
        stack.push(val);
        sums.add(0);
    }

    private void inc(int idx, int val) {
        if (idx >= 0) {
            sums.set(idx, sums.get(idx) + val);
        }
    }

    public int pop() {
        int inc = sums.get(stack.size() - 1);
        int val = stack.pop() + inc;
        inc(stack.size() - 1, inc);
        sums.set(stack.size(), 0);
        return val;
    }

    public void increment(int inc, int count) {
        inc(Math.min(count - 1, stack.size() - 1), inc);
    }
}
