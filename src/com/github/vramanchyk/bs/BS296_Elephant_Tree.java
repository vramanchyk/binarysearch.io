package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS296_Elephant_Tree {

    public Tree solve(Tree root) {
        if (root == null) {
            return null;
        }

        Tree left = solve(root.left);
        Tree right = solve(root.right);

        root.val += (left == null ? 0 : left.val) + (right == null ? 0 : right.val);
        return root;
    }
}
