package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS066_Sum_Of_The_Deepest_Nodes {

    private int maxLevel;

    private int maxSum;

    private void traverse(Tree node, int level) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (maxLevel < level) {

                maxLevel = level;
                maxSum = node.val;

            } else if (maxLevel == level) {
                maxSum += node.val;
            }

            return;
        }

        if (node.left != null) {
            traverse(node.left, level + 1);
        }

        if (node.right != null) {
            traverse(node.right, level + 1);
        }
    }

    public int solve(Tree root) {
        traverse(root, 1);
        return maxSum;
    }
}
