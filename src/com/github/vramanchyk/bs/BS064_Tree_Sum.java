package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS064_Tree_Sum {

    public int solve(Tree root) {
        if (root == null) {
            return 0;
        }

        return root.val + solve(root.right) + solve(root.left);
    }
}
