package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS138_Count_BST_Nodes_In_Range {

    public int solve(Tree root, int lo, int hi) {

        if (root == null) {
            return 0;
        }

        if (root.val < lo) {
            return solve(root.right, lo, hi);
        }

        if (hi < root.val) {
            return solve(root.left, lo, hi);
        }

        return 1 + solve(root.left, lo, hi) + solve(root.right, lo, hi);
    }
}
