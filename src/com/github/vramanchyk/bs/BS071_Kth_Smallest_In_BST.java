package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/30/20.
 */
public class BS071_Kth_Smallest_In_BST {

    private int k;

    private Tree answer;

    private void traverse(Tree node) {
        if (node == null || answer != null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (k-- == 0) {
                answer = node;
            }

            return;
        }

        traverse(node.left);

        if (k-- == 0) {
            answer = node;
            return;
        }

        traverse(node.right);
    }

    public int solve(Tree root, int k) {
        this.k = k;
        traverse(root);
        return answer.val;
    }
}
