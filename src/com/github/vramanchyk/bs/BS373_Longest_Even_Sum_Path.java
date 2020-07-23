package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS373_Longest_Even_Sum_Path {

    private int answer;

    private int[] traverse(Tree root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) {

            answer = Math.max(answer, 1);

            if (root.val % 2 == 0) {
                return new int[]{1, 0};
            }

            return new int[]{0, 1};
        }

        final int[] left = traverse(root.left);
        final int[] right = traverse(root.right);

        int cur = 0;
        if (root.val % 2 == 0) {
            cur = 1 + left[0] + right[0];
            if (left[1] != 0 && right[1] != 0) {
                cur = Math.max(cur, 1 + left[1] + right[1]);
            }
        } else {
            if (right[1] != 0) {
                cur = Math.max(cur, 1 + left[0] + right[1]);
            }

            if (left[1] != 0) {
                cur = Math.max(cur, 1 + left[1] + right[0]);
            }
        }

        answer = Math.max(answer, cur);

        int even = Math.max(left[0], right[0]);
        int odd = Math.max(left[1], right[1]);


        if (root.val % 2 == 0) {
            return new int[]{even + 1, odd == 0 ? 0 : odd + 1};
        }

        return new int[]{Math.max(even == 0 ? 0 : even + 1, odd + 1), odd + 1};
    }

    public int solve(Tree root) {
        traverse(root);
        return answer;
    }
}
