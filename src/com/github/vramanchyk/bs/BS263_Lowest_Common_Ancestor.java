package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS263_Lowest_Common_Ancestor {

    private Tree lca;

    private boolean[] traverse(Tree node, int a, int b) {
        if (node == null) {
            return new boolean[]{false, false};
        }

        if (lca != null) {
            return new boolean[]{true, true};
        }

        boolean[] left = traverse(node.left, a, b);
        boolean[] right = traverse(node.right, a, b);

        boolean[] result = new boolean[]{
                left[0] || right[0] || node.val == a,
                left[1] || right[1] || node.val == b
        };

        if (result[0] && result[1] && lca == null) {
            lca = node;
        }

        return result;
    }

    public int solve(Tree root, int a, int b) {
        traverse(root, a, b);
        return lca.val;
    }
}
