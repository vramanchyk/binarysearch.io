package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS085_Most_Frequent_Subtree_Sum {

    private int traverse(Tree node, Map<Integer, Integer> counts) {
        if (node == null) {
            return 0;
        }

        int curSum = node.val + traverse(node.left, counts) + traverse(node.right, counts);
        counts.put(curSum, counts.getOrDefault(curSum, 0) + 1);

        return curSum;
    }

    public int solve(Tree root) {
        final Map<Integer, Integer> counts = new HashMap<>();
        traverse(root, counts);

        int maxCount = -1;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> en : counts.entrySet()) {
            if (en.getValue() > maxCount) {
                maxCount = en.getValue();
                maxValue = en.getKey();
            }
        }

        return maxValue;
    }
}
