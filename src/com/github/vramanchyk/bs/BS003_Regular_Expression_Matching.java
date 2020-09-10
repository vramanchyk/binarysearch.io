package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/8/20.
 */
public class BS003_Regular_Expression_Matching {

    private boolean match(char ch, char pat) {
        return pat == '.' || pat == ch;
    }

    private boolean find(int cursor, String str, int offset, String pat) {
        if (offset == pat.length()) {
            return cursor == str.length();
        }

        final char ch = pat.charAt(offset);

        if (offset + 1 < pat.length() && pat.charAt(offset + 1) == '*') {

            if (find(cursor, str, offset + 2, pat)) {
                return true;
            }

            while (cursor < str.length() && match(str.charAt(cursor), ch)) {
                if (find(cursor + 1, str, offset + 2, pat)) {
                    return true;
                }
                cursor++;
            }

            return false;

        } else {

            if (ch == '.') {
                return find(cursor + 1, str, offset + 1, pat);
            }

            if (cursor == str.length() || !match(str.charAt(cursor), pat.charAt(offset))) {
                return false;
            }

            return find(cursor + 1, str, offset + 1, pat);
        }
    }

    public boolean solve(String pattern, String s) {
        return find(0, s, 0, pattern);
    }
}
