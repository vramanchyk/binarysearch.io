package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class BS082_Tree_Pruning {

    private Tree prune(Tree node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return node.val == 0 ? null : node;
        }

        node.left = prune(node.left);
        node.right = prune(node.right);

        if (node.left == null && node.right == null) {
            return node.val == 0 ? null : node;
        }

        return node;
    }

    public Tree solve(Tree root) {
        if (root == null) {
            return null;
        }

        return prune(root);
    }
}
