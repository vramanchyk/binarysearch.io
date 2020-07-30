package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS233_Maximum_Non_Adjacent_Tree_Sum {

    private int[] traverse(Tree node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        if (node.left == null && node.right == null) {
            return new int[]{node.val, 0};
        }

        final int[] left = traverse(node.left);
        final int[] right = traverse(node.right);

        int include = node.val + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{include, exclude};
    }

    public int solve(Tree root) {
        final int[] result = traverse(root);
        return Math.max(result[0], result[1]);
    }
}
