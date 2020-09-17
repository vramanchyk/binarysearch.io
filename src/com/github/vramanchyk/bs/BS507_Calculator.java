package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiFunction;

/**
 * Created by Vitali Ramanchyk on 9/16/20.
 */
public class BS507_Calculator {

    private enum Op {
        PLUS(0, '+', (a, b) -> a + b),
        MINUS(0, '-', (a, b) -> a - b),
        MUL(1, '*', (a, b) -> a * b),
        DIV(1, '/', (a, b) -> {
            if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
                return a / b;
            }
            return a / b - (a % b == 0 ? 0 : 1);
        });

        private final char ch;

        private final int priority;

        private final BiFunction<Integer, Integer, Integer> f;

        Op(int priority, char ch, BiFunction<Integer, Integer, Integer> f) {
            this.f = f;
            this.ch = ch;
            this.priority = priority;
        }

        int eval(int a, int b) {
            return f.apply(a, b);
        }

        public static Op of(char ch) {
            for (Op op : values()) {
                if (ch == op.ch) {
                    return op;
                }
            }

            throw new IllegalArgumentException();
        }
    }

    private int cursor;

    private String str;

    private boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    private int nextNum() {

        boolean negation = false;
        if (str.charAt(cursor) == '-') {
            negation = true;
            cursor++;
        }

        int num = 0;
        while (cursor < str.length() && isDigit(str.charAt(cursor))) {
            num = num * 10 + (str.charAt(cursor++) - 48);
        }

        return negation ? -num : num;
    }

    private Op nextOp() {
        if (cursor == str.length()) {
            return null;
        }
        return Op.of(str.charAt(cursor++));
    }

    public int solve(String s) {
        this.cursor = 0;
        this.str = s;

        final Deque<Integer> nums = new ArrayDeque<>();
        final Deque<Op> ops = new ArrayDeque<>();

        boolean readNum = true;
        while (cursor < s.length()) {

            if (readNum) {
                nums.push(nextNum());
            } else {
                final Op op = nextOp();

                while (!ops.isEmpty() && ops.peek().priority >= op.priority) {
                    int right = nums.pop();
                    int left = nums.pop();
                    Op lastOp = ops.pop();

                    nums.push(lastOp.eval(left, right));
                }

                ops.push(op);
            }

            readNum ^= true;
        }

        while (!ops.isEmpty()) {
            int right = nums.pop();
            int left = nums.pop();
            Op op = ops.pop();

            nums.push(op.eval(left, right));
        }

        return nums.pop();
    }
}
