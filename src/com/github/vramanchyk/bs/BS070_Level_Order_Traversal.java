package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS070_Level_Order_Traversal {

    public int[] solve(Tree root) {

        if (root == null) {
            return new int[]{};
        }

        final List<Integer> result = new ArrayList<>();
        final Queue<Tree> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int cnt = 0; cnt < count; cnt++) {
                Tree cur = queue.poll();
                result.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        return result.stream().mapToInt(v -> v).toArray();
    }
}
