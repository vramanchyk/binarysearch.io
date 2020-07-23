package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;
import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS266_Linked_List_To_Binary_Search_Tree {

    public Tree solve(LLNode node) {
        if (node == null) {
            return null;
        }

        LLNode start = node;
        LLNode fast = node;
        LLNode last = null;

        while (fast != null && fast.next != null) {
            last = node;
            node = node.next;
            fast = fast.next.next;
        }

        Tree root = new Tree();
        root.val = node.val;

        if (last != null) {
            last.next = null;
            root.left = solve(start);
        }

        root.right = solve(node.next);

        return root;
    }
}
