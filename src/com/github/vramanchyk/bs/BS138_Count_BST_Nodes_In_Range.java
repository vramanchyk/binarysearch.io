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

        int cnt = 0;

        if (lo <= root.val && root.val <= hi) {
            cnt++;
        }

        if (hi > root.val) {
            cnt += solve(root.right, Math.max(lo, root.val + 1), hi);
        }

        if (lo < root.val) {
            cnt += solve(root.left, lo, Math.min(root.val - 1, hi));
        }

        return cnt;
    }
}
