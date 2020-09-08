package com.github.vramanchyk.bs;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS682_Blocks_To_Spell_Word {

    private boolean canSpell(int cur, String w, Map<Character, BitSet> map, int visited) {
        if (cur == w.length()) {
            return true;
        }

        BitSet set = map.get(w.charAt(cur));
        if (set == null) {
            return false;
        }

        for (int i = set.nextSetBit(0); i >= 0; i = set.nextSetBit(i + 1)) {
            if (((visited >> i) & 1) == 0) {
                if (canSpell(cur + 1, w, map, visited | (1 << i))) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean solve(String[] words, String target) {
        Map<Character, BitSet> map = new HashMap<>();

        for (int index = 0; index < words.length; index++) {
            final String word = words[index];

            for (char ch : word.toCharArray()) {
                map.computeIfAbsent(ch, v -> new BitSet()).set(index);
            }
        }

        return canSpell(0, target, map, 0);
    }
}
