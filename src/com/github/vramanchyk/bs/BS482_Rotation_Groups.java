package com.github.vramanchyk.bs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS482_Rotation_Groups {

    private boolean exists(String word, Set<String> groups) {
        for (String group : groups) {
            if (group.length() == word.length() * 2) {
                if (group.contains(word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int solve(String[] words) {

        final Set<String> groups = new HashSet<>();
        for (String word : words) {
            if (!exists(word, groups)) {
                groups.add(word + word);
            }
        }

        return groups.size();
    }
}
