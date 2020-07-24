package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS202_Delete_Even_Leaves {

    public Tree solve(Tree root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (root.val % 2 == 0) {
                return null;
            }

            return root;
        }

        root.left = solve(root.left);
        root.right = solve(root.right);

        if (root.left == null && root.right == null) {
            if (root.val % 2 == 0) {
                return null;
            }
        }

        return root;
    }
}
