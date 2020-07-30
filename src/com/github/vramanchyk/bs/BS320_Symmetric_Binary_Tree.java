package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS320_Symmetric_Binary_Tree {

    private boolean isSymmetric(Tree a, Tree b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }

    public boolean solve(Tree root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }
}
