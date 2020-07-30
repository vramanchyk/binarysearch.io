package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS241_List_To_Binary_Search_Tree {

    private Tree get(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }

        final int m = l + (r - l + 1) / 2;

        Tree node = new Tree();
        node.val = nums[m];
        node.left = get(l, m - 1, nums);
        node.right = get(m + 1, r, nums);

        return node;
    }

    public Tree solve(int[] nums) {
        return get(0, nums.length - 1, nums);
    }
}
