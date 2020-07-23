package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS065_Leftmost_Deepest_Tree_Node {

    private int maxLevel;

    private int value;

    private void traverse(Tree node, int level) {
        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            maxLevel = level;
            value = node.val;
        }

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }

    public int solve(Tree root) {
        traverse(root, 1);
        return value;
    }
}
