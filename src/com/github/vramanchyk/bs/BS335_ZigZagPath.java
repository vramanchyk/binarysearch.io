package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;
import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS335_ZigZagPath {

    public Tree solve(LLNode node) {
        if (node == null) {
            return null;
        }

        Tree root = new Tree();
        root.val = node.val;

        Tree last = root;

        while (node.next != null) {
            node = node.next;
            if (node.val >= last.val) {
                last.right = new Tree();
                last = last.right;
            } else {
                last.left = new Tree();
                last = last.left;
            }

            last.val = node.val;
        }

        return root;
    }
}
