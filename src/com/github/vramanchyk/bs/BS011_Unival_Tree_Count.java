package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/26/20.
 */
public class BS011_Unival_Tree_Count {

    private int answer = 0;

    public boolean traverse(Tree root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            answer++;
            return true;
        }

        boolean l = root.left == null || (traverse(root.left) & root.left.val == root.val);
        boolean r = root.right == null || (traverse(root.right) & root.right.val == root.val);

        if (l & r) {
            answer++;
            return true;
        }

        return false;
    }

    public int solve(Tree root) {
        traverse(root);
        return answer;
    }
}
