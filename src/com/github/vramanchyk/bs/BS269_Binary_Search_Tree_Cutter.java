package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS269_Binary_Search_Tree_Cutter {

    public Tree solve(Tree root, int lo, int hi) {
        if (root == null) {
            return null;
        }

        if (root.val < lo) {
            root.left = null;
            return solve(root.right, lo, hi);
        }

        if (hi < root.val) {
            root.right = null;
            return solve(root.left, lo, hi);
        }

        root.left = solve(root.left, lo, hi);
        root.right = solve(root.right, lo, hi);

        return root;
    }
}
