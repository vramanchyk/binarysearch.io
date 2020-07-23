package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS463_Longest_Common_Prefix {

    public String solve(String[] words) {

        if (words.length == 0) {
            return "";
        }

        int prefix = 0;
        while (true) {

            char ch = words[0].charAt(prefix);
            for (String word : words) {
                if (prefix >= word.length() || word.charAt(prefix) != ch) {
                    return words[0].substring(0, prefix);
                }
            }

            prefix++;
        }
    }
}
