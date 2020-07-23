package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS163_Pairwise_Linked_List_Swap {

    public LLNode solve(LLNode node) {

        if (node == null) {
            return null;
        }

        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        while (node != null) {

            LLNode next = node.next;
            LLNode shift = next == null ? null : next.next;

            if (next != null) {
                tail.next = next;
                tail.next.next = null;
                tail = next;
            }

            tail.next = node;
            node.next = null;
            tail = node;

            node = shift;
        }

        return dummy.next;
    }
}
