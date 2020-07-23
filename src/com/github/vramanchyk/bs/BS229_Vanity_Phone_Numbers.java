package com.github.vramanchyk.bs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class BS229_Vanity_Phone_Numbers {

    private final char[][] MAP = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    private List<String> find(int idx, String digits) {

        if (idx == digits.length()) {
            return Collections.singletonList("");
        }

        final char digit = digits.charAt(idx);

        List<String> suffixes = find(idx + 1, digits);
        List<String> result = new LinkedList<>();

        for (char ch : MAP[digit - '2']) {
            for (String suffix : suffixes) {
                result.add(ch + suffix);
            }
        }

        return result;
    }

    public String[] solve(String digits) {
        return find(0, digits).toArray(new String[0]);
    }
}
