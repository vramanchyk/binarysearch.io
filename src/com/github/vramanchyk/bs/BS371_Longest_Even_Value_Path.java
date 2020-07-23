package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS371_Longest_Even_Value_Path {

    private int answer;

    private int traverse(Tree root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            answer = Math.max(answer, 1);
            return root.val % 2 == 0 ? 1 : 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        if (root.val % 2 != 0) {
            return 0;
        }

        answer = Math.max(answer, 1 + left + right);
        return 1 + Math.max(left, right);
    }

    public int solve(Tree root) {
        traverse(root);
        return answer;
    }
}
