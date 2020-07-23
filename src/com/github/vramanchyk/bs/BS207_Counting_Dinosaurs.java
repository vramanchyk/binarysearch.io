package com.github.vramanchyk.bs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS207_Counting_Dinosaurs {

    public int solve(String animals, String dinosaurs) {
        final Set<Character> dins = new HashSet<>();

        for (char ch : dinosaurs.toCharArray()) {
            dins.add(ch);
        }

        int result = 0;
        for (char ch : animals.toCharArray()) {
            if (dins.contains(ch)) {
                result++;
            }
        }

        return result;
    }
}
