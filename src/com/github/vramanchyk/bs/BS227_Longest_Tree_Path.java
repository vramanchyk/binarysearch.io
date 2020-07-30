package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS227_Longest_Tree_Path {

    private int maxPath;

    private int traverse(Tree node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        final int left = traverse(node.left);
        final int right = traverse(node.right);

        maxPath = Math.max(maxPath, left + right + 1);

        return Math.max(left, right) + 1;
    }

    public int solve(Tree root) {
        traverse(root);
        return maxPath;
    }
}
