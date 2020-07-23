package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS562_Only_Child {

    public int solve(Tree root) {
        if (root == null) {
            return 0;
        }

        int cur = solve(root.left) + solve(root.right);
        int add = (root.left == null || root.right == null) && (root.left != root.right) ? 1 : 0;
        return cur + add;
    }
}
