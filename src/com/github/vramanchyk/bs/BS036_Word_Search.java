package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS036_Word_Search {

    private boolean checkHor(int r, int c, String[][] b, String w) {
        if (c + w.length() > b[r].length) {
            return false;
        }

        int offset = 0;
        for (char ch : w.toCharArray()) {
            if (b[r][c + offset++].charAt(0) != ch) {
                return false;
            }
        }

        return true;
    }

    private boolean checkVer(int r, int c, String[][] b, String w) {
        if (r + w.length() > b.length) {
            return false;
        }

        int offset = 0;
        for (char ch : w.toCharArray()) {
            if (b[r + offset++][c].charAt(0) != ch) {
                return false;
            }
        }

        return true;
    }

    public boolean solve(String[][] board, String word) {
        final int n = board.length;
        final int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j].charAt(0) == word.charAt(0)) {
                    if (checkHor(i, j, board, word) || checkVer(i, j, board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
