package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS067_Twin_Trees {

    public boolean solve(Tree root0, Tree root1) {
        if (root0 == null && root1 == null) {
            return true;
        }

        if (root0 == null || root1 == null) {
            return false;
        }

        if (root0.val != root1.val) {
            return false;
        }

        return solve(root0.left, root1.left) && solve(root0.right, root1.right);
    }
}
