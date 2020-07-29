package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.*;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS554_Second_Place {

    private int level1 = -1;

    private int level2 = -1;

    private void set(int level, int value) {
        if (level > level1) {
            if (level1 > level2) {
                level2 = level1;
            }
            level1 = level;
            return;
        }

        if (level > level2 && level != level1) {
            level2 = level;
        }
    }

    private void traverse(Tree root, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            set(level, root.val);
            return;
        }

        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    public int solve(Tree root) {
        traverse(root, 1);
        return level2 - 1;
    }
}
