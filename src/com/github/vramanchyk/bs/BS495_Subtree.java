package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS495_Subtree {

    private boolean match(Tree root, Tree target) {
        if (root == null && target == null) {
            return true;
        }

        if (root == null || target == null) {
            return false;
        }

        if (root.val != target.val) {
            return false;
        }

        return match(root.left, target.left) && match(root.right, target.right);
    }

    public boolean solve(Tree root, Tree target) {
        if (match(root, target)) {
            return true;
        }

        return match(root.left, target) || match(root.right, target);
    }
}
