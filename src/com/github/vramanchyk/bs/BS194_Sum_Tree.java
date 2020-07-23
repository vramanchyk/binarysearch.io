package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS194_Sum_Tree {

    public boolean solve(Tree root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        final int left = root.left == null ? 0 : root.left.val;
        final int right = root.right == null ? 0 : root.right.val;

        if (left + right != root.val) {
            return false;
        }

        return solve(root.left) && solve(root.right);
    }
}
