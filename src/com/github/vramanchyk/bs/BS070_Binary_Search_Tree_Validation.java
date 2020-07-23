package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS070_Binary_Search_Tree_Validation {

    private boolean validate(Tree root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return validate(root.left, min, root.val - 1) && validate(root.right, root.val + 1, max);
    }

    public boolean solve(Tree root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
