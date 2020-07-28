package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS267_Uno_Tree {

    public boolean solve(Tree root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        int left = root.left == null ? root.val : root.left.val;
        int right = root.right == null ? root.val : root.right.val;

        return root.val == left && root.val == right && solve(root.left) && solve(root.right);
    }
}
