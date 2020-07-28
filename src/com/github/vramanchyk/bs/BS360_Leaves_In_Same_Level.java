package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS360_Leaves_In_Same_Level {

    private int targetLevel = -1;

    private boolean traverse(Tree root, int level) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            if (targetLevel == -1) {
                targetLevel = level;
            }

            return level == targetLevel;
        }

        return traverse(root.left, level + 1) && traverse(root.right, level + 1);
    }

    public boolean solve(Tree root) {
        return traverse(root, 1);
    }
}
