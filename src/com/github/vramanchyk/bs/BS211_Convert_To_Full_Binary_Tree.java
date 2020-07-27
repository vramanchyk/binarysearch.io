package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/27/20.
 */
public class BS211_Convert_To_Full_Binary_Tree {

    public Tree solve(Tree root) {

        if (root == null) {
            return null;
        }

        root.left = solve(root.left);
        root.right = solve(root.right);

        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left == null || root.right == null) {
            return root.left == null ? root.right : root.left;
        }

        return root;
    }
}
