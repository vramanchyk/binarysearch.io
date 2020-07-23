package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS251_Ancient_Astranaut_Theory {

    public boolean solve(String dictionary, String s) {

        final Map<Character, Integer> indexes = new HashMap<>();
        final int len = dictionary.length();

        for (int index = 0; index < len; index++) {
            indexes.put(dictionary.charAt(index), index);
        }

        int lastIndex = -1;

        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                Integer index = indexes.get(ch);

                if (index != null) {
                    if (index < lastIndex) {
                        return false;
                    }

                    lastIndex = index;
                }
            }
        }

        return true;
    }
}
