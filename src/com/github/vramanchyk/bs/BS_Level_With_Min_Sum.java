package com.github.vramanchyk.bs;

import java.util.LinkedList;
import java.util.Queue;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS_Level_With_Min_Sum {

    public int solve(Tree root) {

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        int minSum = root.val;
        int minLevel = 0;

        int levelNum = 0;

        while (!queue.isEmpty()) {
            Queue<Tree> level = new LinkedList<>();

            int curSum = 0;
            while (!queue.isEmpty()) {
                final Tree cur = queue.poll();
                curSum += cur.val;
                if (cur.left != null) {
                    level.add(cur.left);
                }
                if (cur.right != null) {
                    level.add(cur.right);
                }
            }

            queue = level;
            if (curSum < minSum) {
                minSum = curSum;
                minLevel = levelNum;
            }

            levelNum++;
        }

        return minLevel;
    }
}
