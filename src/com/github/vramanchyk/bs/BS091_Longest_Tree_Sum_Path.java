package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS091_Longest_Tree_Sum_Path {

    private int[] traverse(Tree root, int level) {
        if (root == null) {
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{level, root.val};
        }

        int[] left = traverse(root.left, level + 1);
        int[] right = traverse(root.right, level + 1);

        if (left[0] > right[0] || (left[0] == right[0] && left[1] > right[1])) {
            return new int[]{left[0], left[1] + root.val};
        }

        return new int[]{right[0], right[1] + root.val};
    }

    public int solve(Tree root) {
        int[] result = traverse(root, 1);
        return result[1];
    }
}
