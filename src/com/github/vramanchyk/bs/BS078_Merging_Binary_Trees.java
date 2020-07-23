package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class BS078_Merging_Binary_Trees {

    public Tree solve(Tree node0, Tree node1) {
        if (node0 == null && node1 == null) {
            return null;
        }

        Tree root = new Tree();
        if (node0 != null) {
            root.val += node0.val;
        }

        if (node1 != null) {
            root.val += node1.val;
        }

        root.left = solve(
                node0 == null ? null : node0.left,
                node1 == null ? null : node1.left
        );

        root.right = solve(
                node0 == null ? null : node0.right,
                node1 == null ? null : node1.right
        );

        return root;
    }
}
