package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 8/8/20.
 */
public class BS132_Largest_Binary_Search_Subtree {

    private int count;

    private Tree answer;

    private void assign(int cnt, Tree node) {
        if (cnt > count) {
            count = cnt;
            answer = node;
        }
    }

    private int traverse(Tree root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            assign(1, root);
            return 1;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        boolean hasLeft = root.left == null || root.left.val < root.val;
        boolean hasRight = root.right == null || root.right.val > root.val;

        if (hasLeft && hasRight) {
            if (left >= 0 && right >= 0) {
                assign(left + right + 1, root);
                return left + right + 1;
            }
        }

        return -1;
    }

    public Tree solve(Tree root) {
        traverse(root);
        return answer;
    }
}
