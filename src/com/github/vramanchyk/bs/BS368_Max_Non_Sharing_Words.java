package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS368_Max_Non_Sharing_Words {

    private int getState(String str) {
        int result = 0;

        for (char ch : str.toCharArray()) {
            result |= (1 << (ch - 'a'));
        }

        return result;
    }

    public int solve(String[] words) {

        final int n = words.length;
        int[] states = new int[n];
        for (int index = 0; index < n; index++) {
            states[index] = getState(words[index]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((states[i] & states[j]) == 0) {
                    max = Math.max(max, words[i].length() + words[j].length());
                }
            }
        }

        return max;
    }
}
