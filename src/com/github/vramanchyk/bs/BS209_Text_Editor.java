package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS209_Text_Editor {

    public String solve(String s) {
        int uk = 0;
        final int n = s.length();
        final char[] stack = new char[n];

        for (char ch : s.toCharArray()) {
            if (ch == '-' && uk > 0 && stack[uk - 1] == '<') {
                uk = Math.max(uk - 2, 0);
            } else {
                stack[uk++] = ch;
            }
        }

        return new String(stack, 0, uk);
    }
}
