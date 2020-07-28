package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;
import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS247_Binary_Search_Tree_To_Linked_List {

    private LLNode tail;

    private void traverse(Tree root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        LLNode node = new LLNode();
        node.val = root.val;

        tail.next = node;
        tail = node;

        traverse(root.right);
    }

    public LLNode solve(Tree root) {
        if (root == null) {
            return null;
        }

        LLNode dummy = new LLNode();
        tail = dummy;

        traverse(root);
        return dummy.next;
    }
}
