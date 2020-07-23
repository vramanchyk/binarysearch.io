package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS438_MinimaxTree {

    private int max(Tree node) {
        return node == null ? Integer.MIN_VALUE : node.val;
    }

    private int min(Tree node) {
        return node == null ? Integer.MAX_VALUE : node.val;
    }

    private void traverse(Tree node, int level) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);

        if (level % 2 == 1) {
            node.val = Math.max(max(node.left), max(node.right));
        } else {
            node.val = Math.min(min(node.left), min(node.right));
        }
    }

    public Tree solve(Tree root) {
        if (root == null) {
            return null;
        }

        traverse(root, 1);
        return root;
    }
}
