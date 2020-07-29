package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS154_S_Expression_Evaluation {

    private String str;
    private int cursor;

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private int readNum() {

        int mul = 1;
        int result = 0;

        if (str.charAt(cursor) == '-') {
            mul = -1;
            cursor++;
        }

        while (cursor < str.length() && isDigit(str.charAt(cursor))) {
            result = result * 10 + str.charAt(cursor++) - '0';
        }

        return mul * result;
    }

    private int operation() {
        if (str.charAt(cursor) != '(') {
            return readNum();
        }

        cursor++;
        char op = str.charAt(cursor++);

        cursor++;
        int left = operation();

        cursor++;
        int right = operation();

        int result = 0;

        if (op == '-') {
            result = left - right;
        } else if (op == '+') {
            result = left + right;
        } else if (op == '*') {
            result = left * right;
        } else {
            result = left / right;
        }

        cursor++;
        return result;
    }

    public int solve(String s) {
        str = s;
        return operation();
    }
}
