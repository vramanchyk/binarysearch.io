package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS488_Subtree {

    private boolean subtree = false;

    private int getHeight(Tree node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private boolean subtree(Tree a, Tree b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return subtree(a.left, b.left) && subtree(a.right, b.right);
    }

    private int traverse(Tree root, Tree target, int h) {

        if (root == null) {
            return 0;
        }

        if (subtree) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            if (h == 1 && root.val == target.val) {
                subtree = true;
            }

            return 1;
        }

        final int leftH = traverse(root.left, target, h);
        final int rightH = traverse(root.right, target, h);

        if (leftH == -1 || rightH == -1) {
            return -1;
        }

        int curH = 1 + Math.max(leftH, rightH);

        if (curH == h) {
            subtree = subtree(root, target);
        }

        return curH;
    }

    public boolean solve(Tree root, Tree target) {
        final int targetH = getHeight(target);
        traverse(root, target, targetH);
        return subtree;
    }
}
