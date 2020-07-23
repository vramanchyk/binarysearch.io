package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS387_String_Similarity {

    public boolean solve(String s, String t, int k) {

        if (k == 0) {
            return true;
        }

        final int n = s.length();
        final int m = t.length();

        int[][] max = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    max[i][j] = 0;
                } else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        max[i][j] = max[i - 1][j - 1] + 1;
                        if (max[i][j] >= k) {
                            return true;
                        }
                    } else {
                        max[i][j] = 0;
                    }
                }
            }
        }

        return false;
    }
}
