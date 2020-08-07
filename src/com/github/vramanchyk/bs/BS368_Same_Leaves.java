package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS368_Same_Leaves {

    private void traverse(Tree node, List<Integer> leaves) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        traverse(node.left, leaves);
        traverse(node.right, leaves);
    }

    public boolean solve(Tree a, Tree b) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        traverse(a, l1);
        traverse(b, l2);

        return Objects.equals(l1, l2);
    }
}
