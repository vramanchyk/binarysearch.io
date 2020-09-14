package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 9/14/20.
 */
public class BS494_Binary_Tree_Longest_Consecutive_Path {

    private int maxLen = 1;

    private int[] traverse(Tree root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{1, 1};
        }

        int[] l = traverse(root.left);
        int[] r = traverse(root.right);

        boolean decLeft = root.left == null || root.left.val == root.val - 1;
        boolean decRight = root.right == null || root.right.val == root.val - 1;

        boolean incLeft = root.left == null || root.left.val == root.val + 1;
        boolean incRight = root.right == null || root.right.val == root.val + 1;

        if (decLeft) {
            maxLen = Math.max(maxLen, 1 + l[0]);
        }

        if (incLeft) {
            maxLen = Math.max(maxLen, 1 + l[1]);
        }

        if (decRight) {
            maxLen = Math.max(maxLen, 1 + r[0]);
        }

        if (incRight) {
            maxLen = Math.max(maxLen, 1 + r[1]);
        }

        if (incLeft && decRight) {
            maxLen = Math.max(maxLen, 1 + l[1] + r[0]);
        }

        if (decLeft && incRight) {
            maxLen = Math.max(maxLen, 1 + l[0] + r[1]);
        }

        int inc = Math.max(incLeft ? 1 + l[1] : 1, incRight ? 1 + r[1] : 1);
        int dec = Math.max(decLeft ? 1 + l[0] : 1, decRight ? 1 + r[0] : 1);

        return new int[]{dec, inc};
    }

    public int solve(Tree root) {
        if (root == null) {
            return 0;
        }

        traverse(root);

        return maxLen;
    }
}
