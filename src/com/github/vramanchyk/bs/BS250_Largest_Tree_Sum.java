package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS250_Largest_Tree_Sum {

    private int answer;

    private int traverse(Tree root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = root.left == null ? 0 : traverse(root.left);
        int right = root.right == null ? 0 : traverse(root.right);

        answer = Math.max(answer, root.val + left);
        answer = Math.max(answer, root.val + right);
        answer = Math.max(answer, root.val + left + right);

        return Math.max(root.val, root.val + Math.max(left, right));
    }

    public int solve(Tree root) {
        if (root == null) {
            return 0;
        }

        answer = root.val;
        traverse(root);
        return answer;
    }
}
