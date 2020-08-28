package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 8/28/20.
 */
public class BS410_Overchoice {

    private final List<String> result = new ArrayList<>();

    private boolean isLetter(char ch) {
        return 'a' <= ch && ch <= 'z';
    }

    private void find(String s, int offset, String cur) {

        if (offset >= s.length()) {
            result.add(cur);
            return;
        }

        StringBuilder bld = new StringBuilder();
        while (offset < s.length() && isLetter(s.charAt(offset))) {
            bld.append(s.charAt(offset));
            offset++;
        }

        cur += bld.toString();

        offset++;
        bld.setLength(0);
        while (offset < s.length() && s.charAt(offset) != ']') {
            bld.append(s.charAt(offset));
            offset++;
        }

        if (bld.length() != 0) {
            String[] parts = bld.toString().split("\\|");
            for (String part : parts) {
                find(s, offset + 1, cur + part);
            }
        } else {
            find(s, offset + 1, cur);
        }
    }

    public String[] solve(String s) {
        find(s, 0, "");
        result.sort(Comparator.naturalOrder());
        return result.toArray(new String[0]);
    }
}
