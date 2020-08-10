package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.*;

/**
 * Created by Vitali Ramanchyk on 8/10/20.
 */
public class BS372_Longest_Even_Sum_Path {
    private int maxPath;

    private int[] getEven(int[] l, int[] r) {
        int evenPath = Math.max(l[0] + r[0], l[1] + r[1]);
        int oddPath = Math.max(l[0] + r[1], l[1] + r[0]);

        if (evenPath != 0) {
            maxPath = Math.max(maxPath, evenPath + 1);
        }

        int evenSide = Math.max(l[0], r[0]);
        int oddSide = Math.max(l[1], r[1]);

        return new int[] {evenSide + 1, oddSide > 0 ? oddSide + 1 : 0};
    }

    private int[] getOdd(int[] l, int[] r) {
        int evenPath = Math.max(l[0] + r[0], l[1] + r[1]);
        int oddPath = Math.max(l[0] + r[1], l[1] + r[0]);

        if (oddPath != 0) {
            maxPath = Math.max(maxPath, oddPath + 1);
        }

        int evenSide = Math.max(l[0], r[0]);
        int oddSide = Math.max(l[1], r[1]);

        return new int[] {oddSide > 0 ? oddSide + 1 : 0, evenSide + 1};
    }

    private int[] traverse(Tree node) {
        if (node == null) {
            return new int[] {0, 0};
        }

        if (node.left == null && node.right == null) {

            if (node.val % 2 == 0) {
                maxPath = Math.max(maxPath, 1);
                return new int[] {1, 0};
            }

            return new int[] {0, 1};
        }

        final int[] l = traverse(node.left);
        final int[] r = traverse(node.right);

        if (node.val % 2 == 0) {
            return getEven(l, r);
        }

        return getOdd(l, r);
    }

    public int solve(Tree root) {
        traverse(root);
        return maxPath;
    }
}
