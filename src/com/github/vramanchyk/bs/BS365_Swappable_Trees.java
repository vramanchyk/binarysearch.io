package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS365_Swappable_Trees {

    public boolean solve(Tree a, Tree b) {

        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        if (solve(a.left, b.left) && solve(a.right, b.right)) {
            return true;
        }

        return solve(a.left, b.right) && solve(a.right, b.left);
    }
}
