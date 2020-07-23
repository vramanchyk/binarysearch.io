package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS322_Partition_Tree {

    public int[] solve(Tree root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{1, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        return new int[]{left[0] + right[0], left[1] + right[1] + 1};
    }
}
