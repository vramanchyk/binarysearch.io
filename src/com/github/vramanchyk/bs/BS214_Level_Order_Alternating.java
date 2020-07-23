package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS214_Level_Order_Alternating {

    public int[] solve(Tree root) {
        if (root == null) {
            return new int[0];
        }

        List<List<Integer>> result = new ArrayList<>();

        final Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        int levelNum = 0;
        while (!queue.isEmpty()) {
            levelNum++;
            int levelCount = queue.size();

            LinkedList<Integer> level = new LinkedList<>();
            result.add(level);

            for (int count = 0; count < levelCount; count++) {
                Tree node = queue.poll();

                int value = node.val;
                if (levelNum % 2 == 0) {
                    level.addFirst(value);
                } else {
                    level.addLast(value);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result.stream().flatMap(Collection::stream).mapToInt(i -> i).toArray();
    }
}
