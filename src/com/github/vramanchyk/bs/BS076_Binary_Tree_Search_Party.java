package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS076_Binary_Tree_Search_Party {

    public boolean solve(Tree root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }

        if (val < root.val) {
            return solve(root.left, val);
        }

        return solve(root.right, val);
    }
}
