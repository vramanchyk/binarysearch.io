package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS388_Linked_List_Partitioning {

    private LLNode add(LLNode tail, LLNode node) {
        if (node == null) {
            return tail;
        }

        tail.next = node;
        tail = tail.next;
        tail.next = null;
        return tail;
    }

    public LLNode solve(LLNode node, int k) {
        LLNode less = new LLNode();
        LLNode lessTail = less;

        LLNode eq = new LLNode();
        LLNode eqTail = eq;

        LLNode other = new LLNode();
        LLNode otherTail = other;

        while (node != null) {
            LLNode next = node.next;

            if (node.val < k) {
                lessTail = add(lessTail, node);
            } else if (node.val == k) {
                eqTail = add(eqTail, node);
            } else {
                otherTail = add(otherTail, node);
            }

            node = next;
        }

        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        if (less.next != null) {
            tail.next = less.next;
            tail = lessTail;
        }
        if (eq.next != null) {
            tail.next = eq.next;
            tail = eqTail;
        }

        tail.next = other.next;

        return dummy.next;
    }
}
