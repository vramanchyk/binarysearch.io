package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS073_Invert_Tree {

    public Tree solve(Tree root) {
        if (root == null) {
            return null;
        }

        final Tree left = solve(root.left);
        final Tree right = solve(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
