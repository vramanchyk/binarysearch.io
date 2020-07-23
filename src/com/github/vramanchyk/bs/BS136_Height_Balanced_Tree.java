package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS136_Height_Balanced_Tree {

    private int traverse(Tree root) {
        if (root == null) {
            return 0;
        }

        final int leftH = traverse(root.left);

        if (leftH < 0) {
            return -1;
        }

        final int rightH = traverse(root.right);

        if (rightH < 0) {
            return -1;
        }

        if (Math.abs(leftH - rightH) > 1) {
            return -1;
        }

        return 1 + Math.max(leftH, rightH);
    }

    public boolean solve(Tree root) {
        return traverse(root) >= 0;
    }
}
