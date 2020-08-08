package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS655_Sum_Of_Digit_Paths_In_Tree {

    private int sum;

    private void traverse(Tree root, int value) {
        if (root == null) {
            return;
        }

        value = value * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += value;
            return;
        }

        traverse(root.left, value);
        traverse(root.right, value);
    }

    public int solve(Tree root) {
        traverse(root, 0);
        return sum;
    }
}
