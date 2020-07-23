package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS489_Inorder_Successor {

    public Tree traverse(Tree root, Tree prev, int t) {
        if (root == null) {
            return null;
        }

        if (root.val == t) {
            return prev;
        }

        if (t < root.val) {
            return traverse(root.left, root, t);
        }

        return traverse(root.right, root, t);
    }

    public int solve(Tree root, int t) {
        return traverse(root, null, t).val;
    }
}
