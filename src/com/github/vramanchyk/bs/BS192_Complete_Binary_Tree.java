package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 8/30/20.
 */
public class BS192_Complete_Binary_Tree {

    public boolean solve(Tree root) {

        if (root == null) {
            return true;
        }

        Queue<Tree> levels = new LinkedList<>();
        levels.add(root);

        boolean seenEmpty = false;
        while (!levels.isEmpty()) {
            int levelSize = levels.size();
            while (levelSize-- > 0) {
                final Tree cur = levels.poll();
                if (cur.left != null) {
                    if (seenEmpty) {
                        return false;
                    }
                    levels.add(cur.left);
                } else {
                    seenEmpty = true;
                }

                if (cur.right != null) {
                    if (seenEmpty) {
                        return false;
                    }
                    levels.add(cur.right);
                } else {
                    seenEmpty = true;
                }
            }
        }

        return true;
    }
}
