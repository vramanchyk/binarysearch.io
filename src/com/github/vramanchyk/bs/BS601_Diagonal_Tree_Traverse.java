package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 9/14/20.
 */
public class BS601_Diagonal_Tree_Traverse {

    private void traverse(Tree root, int diag, List<Integer> sums) {
        if (root == null) {
            return;
        }

        if (sums.size() == diag) {
            sums.add(0);
        }

        sums.set(diag, sums.get(diag) + root.val);

        traverse(root.left, diag + 1, sums);
        traverse(root.right, diag, sums);
    }

    public int[] solve(Tree root) {

        if (root == null) {
            return new int[0];
        }

        List<Integer> sums = new ArrayList<>();
        traverse(root, 0, sums);

        return sums.stream().mapToInt(v -> v).toArray();
    }
}
