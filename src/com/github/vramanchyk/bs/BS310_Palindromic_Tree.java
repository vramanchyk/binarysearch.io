package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.List;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS310_Palindromic_Tree {

    private void traverse(Tree root, List<Integer> result) {
        if (root == null) {
            return;
        }

        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }

    private boolean isPalindrome(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l++) != list.get(r--)) {
                return false;
            }
        }

        return true;
    }

    public boolean solve(Tree root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return isPalindrome(result);
    }
}
