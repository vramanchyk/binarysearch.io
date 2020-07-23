package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS084_Climbing_Down_The_Tree {

    public int solve(Tree root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = root.left == null ? 0 : solve(root.left);
        int right = root.right == null ? 0 : solve(root.right);

        return root.val + Math.max(left, right);
    }
}
