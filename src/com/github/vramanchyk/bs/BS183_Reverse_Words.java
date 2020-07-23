package com.github.vramanchyk.bs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS183_Reverse_Words {

    public String solve(String sentence) {

        Deque<String> stack = new LinkedList<>();
        StringBuilder bld = new StringBuilder();

        for (char ch : sentence.toCharArray()) {
            if (ch == ' ') {
                if (bld.length() > 0) {
                    stack.push(bld.toString());
                    bld.setLength(0);
                }
            } else {
                bld.append(ch);
            }
        }

        if (bld.length() > 0) {
            stack.push(bld.toString());
            bld.setLength(0);
        }

        int index = 0;
        while (index < sentence.length()) {
            while (index < sentence.length() && sentence.charAt(index) == ' ') {
                bld.append(' ');
                index++;
            }

            if (!stack.isEmpty()) {
                bld.append(stack.pop());
            }

            while (index < sentence.length() && sentence.charAt(index) != ' ') {
                index++;
            }
        }

        return bld.toString();
    }
}
