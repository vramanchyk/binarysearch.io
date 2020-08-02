package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/30/20.
 */
public class BS469_Milk_And_Eggs {

    private int cursor = 0;

    private String str;

    private boolean operand() {
        if (str.charAt(cursor) == '(') {
            cursor++;
            boolean result = expression();
            cursor++;
            return result;
        }

        if (str.charAt(cursor) == 't') {
            cursor += 4;
            return true;
        } else if (str.charAt(cursor) == 'f') {
            cursor += 5;
            return false;
        }

        return true;
    }

    private boolean expression() {

        final boolean left = operand();
        if (cursor == str.length()) {
            return left;
        }

        cursor++;
        boolean opAnd = false;

        if (str.charAt(cursor) == 'a') {
            cursor += 4;
            opAnd = true;
        }

        if (str.charAt(cursor) == 'o') {
            cursor += 3;
            opAnd = false;
        }

        final boolean right = operand();
        return opAnd ? left && right : left || right;
    }

    public boolean solve(String s) {
        this.str = s;
        return expression();
    }
}
