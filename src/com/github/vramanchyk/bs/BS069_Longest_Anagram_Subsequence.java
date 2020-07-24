package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS069_Longest_Anagram_Subsequence {

    public int solve(String a, String b) {
        int[] countA = new int[26];
        int[] countB = new int[26];

        a.chars().forEach(ch -> countA[ch - 'a']++);
        b.chars().forEach(ch -> countB[ch - 'a']++);

        int ans = 0;
        for (int index = 0; index < 26; index++) {
            ans += Math.min(countA[index], countB[index]);
        }

        return ans;
    }
}
