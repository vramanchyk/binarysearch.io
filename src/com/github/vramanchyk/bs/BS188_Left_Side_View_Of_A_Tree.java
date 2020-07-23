package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.List;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS188_Left_Side_View_Of_A_Tree {

    private void traverse(Tree root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (result.size() < level) {
            result.add(root.val);
        }

        traverse(root.left, level + 1, result);
        traverse(root.right, level + 1, result);
    }

    public int[] solve(Tree root) {
        final List<Integer> result = new ArrayList<>();
        traverse(root, 1, result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
