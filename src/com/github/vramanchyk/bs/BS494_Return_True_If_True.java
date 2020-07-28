package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS494_Return_True_If_True {

    private String str;

    private int cursor = 0;

    private boolean expression() {

        boolean targetValue = true;

        if (str.charAt(cursor) == 't') {
            cursor += 4;
            targetValue = true;
        } else if (str.charAt(cursor) == 'f') {
            cursor += 5;
            targetValue = false;
        }

        if (cursor == str.length()) {
            return targetValue;
        }

        if (str.charAt(cursor) != '?') {
            return targetValue;
        }

        cursor++;

        boolean left = expression();
        cursor++;
        boolean right = expression();

        return targetValue ? left : right;
    }

    public boolean solve(String s) {
        str = s.replaceAll(" ", "");
        return expression();
    }
}
