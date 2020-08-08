package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS630_Partition_String {

    public int[] solve(String s) {
        final int[] positions = new int[26];

        for (int index = 0; index < s.length(); index++) {
            positions[s.charAt(index) - 'a'] = index;
        }

        final List<Integer> result = new ArrayList<>();

        int cursor = 0;
        while (cursor < s.length()) {
            int offset = cursor;
            int max = positions[s.charAt(offset) - 'a'];

            while (offset <= max) {
                max = Math.max(max, positions[s.charAt(offset) - 'a']);
                offset++;
            }

            result.add(offset - cursor);
            cursor = offset;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
