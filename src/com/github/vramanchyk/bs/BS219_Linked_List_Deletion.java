package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS219_Linked_List_Deletion {

    public LLNode solve(LLNode node, int target) {
        LLNode dummy = new LLNode();
        LLNode last = dummy;
        dummy.next = node;

        while (node != null) {

            if (node.val == target) {
                last.next = node.next;
            } else {
                last = node;
            }

            node = node.next;
        }

        return dummy.next;
    }
}
