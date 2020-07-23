package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/18/20.
 */
public class BS151_String_Expansion {

    private int cursor;

    private String str;

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private String readNum() {
        int cnt = 0;

        while (isDigit(str.charAt(cursor))) {
            cnt = cnt * 10 + (str.charAt(cursor++) - '0');
        }

        cursor++;
        String inner = read();
        cursor++;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cnt; i++) {
            result.append(inner);
        }

        return result.toString();
    }

    private String read() {
        StringBuilder result = new StringBuilder();

        while (cursor < str.length()) {
            final char c = str.charAt(cursor);
            if (isDigit(c)) {
                result.append(readNum());
            } else if (c != ')') {
                result.append(c);
                cursor++;
            } else {
                break;
            }
        }

        return result.toString();
    }

    public String solve(String s) {
        this.str = s;
        return read();
    }
}
