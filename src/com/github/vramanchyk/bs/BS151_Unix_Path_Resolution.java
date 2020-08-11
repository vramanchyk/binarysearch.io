package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS151_Unix_Path_Resolution {

    public String[] solve(String[] path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String val : path) {
            if ("..".equals(val)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(val)) {
                stack.push(val);
            }
        }

        int n = stack.size() - 1;
        final String[] result = new String[n + 1];

        while (!stack.isEmpty()) {
            result[n--] = stack.pop();
        }

        return result;
    }
}
