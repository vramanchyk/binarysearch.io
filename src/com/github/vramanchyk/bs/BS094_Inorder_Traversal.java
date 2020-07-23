package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS094_Inorder_Traversal {

    private void traverse(Tree root, List<Integer> result) {
        if (root == null) {
            return;
        }

        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }

    public int[] solve(Tree root) {
        final List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result.stream().mapToInt(val -> val).toArray();
    }
}
