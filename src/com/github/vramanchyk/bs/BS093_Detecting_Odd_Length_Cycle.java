package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/17/20.
 */
public class BS093_Detecting_Odd_Length_Cycle {

    boolean answerFound = false;

    private void traverse(int cur, int prev, boolean color, int[][] g, int[] state, boolean[] colors) {

        if (answerFound) {
            return;
        }

        state[cur] = 1;
        colors[cur] = color;

        for (int target : g[cur]) {
            if (target != prev) {
                if (state[target] == 0) {
                    traverse(target, cur, !color, g, state, colors);
                } else {
                    if (state[target] == 1 && colors[target] == color) {
                        answerFound = true;
                    }
                }
            }

            if (answerFound) {
                return;
            }
        }

        state[cur] = 2;
    }

    public boolean solve(int[][] arr) {
        final int n = arr.length;
        final int[] state = new int[n];
        final boolean[] colors = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                traverse(i, -1, true, arr, state, colors);
            }

            if (answerFound) {
                break;
            }
        }

        return answerFound;
    }
}
