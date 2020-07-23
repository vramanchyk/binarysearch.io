package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS486_Back_To_From_Linked_List {

    private LLNode mid(LLNode node) {

        LLNode last = null;
        LLNode fast = node;

        while (fast != null && fast.next != null) {
            last = node;
            node = node.next;
            fast = fast.next.next;
        }

        return fast == null ? last : node;
    }

    private LLNode reverse(LLNode node) {
        LLNode last = null;

        while (node != null) {
            LLNode next = node.next;
            node.next = last;
            last = node;
            node = next;
        }

        return last;
    }

    private LLNode merge(LLNode a, LLNode b) {
        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        while (a != null && b != null) {
            LLNode aNext = a.next;
            LLNode bNext = b.next;

            tail.next = a;
            tail = tail.next;
            tail.next = null;

            tail.next = b;
            tail = tail.next;
            tail.next = null;

            a = aNext;
            b = bNext;

        }

        if (a != null) {
            tail.next = a;
        }

        if (b != null) {
            tail.next = b;
        }

        return dummy.next;
    }

    public LLNode solve(LLNode node) {
        if (node == null) {
            return null;
        }

        LLNode mid = mid(node);
        LLNode next = mid.next;

        mid.next = null;

        return merge(reverse(next), node);
    }
}
