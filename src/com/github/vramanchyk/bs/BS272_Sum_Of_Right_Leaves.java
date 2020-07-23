package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS272_Sum_Of_Right_Leaves {

    private int traverse(Tree root, boolean right) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return right ? root.val : 0;
        }

        return traverse(root.left, false) + traverse(root.right, true);
    }

    public int solve(Tree root) {
        return traverse(root, false);
    }
}
