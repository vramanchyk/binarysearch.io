package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS149_Sort_Linked_List {

    private LLNode mid(LLNode node) {

        LLNode fast = node;
        LLNode last = null;
        while (fast != null && fast.next != null) {
            last = node;
            node = node.next;
            fast = fast.next.next;
        }

        return fast == null ? last : node;
    }

    private LLNode merge(LLNode a, LLNode b) {
        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        while (a != null && b != null) {
            LLNode aNext = a.next;
            LLNode bNext = b.next;

            if (a.val < b.val) {
                tail.next = a;
                a = aNext;
            } else {
                tail.next = b;
                b = bNext;
            }

            tail = tail.next;
            tail.next = null;
        }

        if (a != null) {
            tail.next = a;
        }

        if (b != null) {
            tail.next = b;
        }

        return dummy.next;
    }

    private LLNode sort(LLNode node) {

        if (node == null) {
            return null;
        }

        if (node.next == null) {
            return node;
        }

        LLNode mid = mid(node);
        LLNode midNext = mid.next;
        mid.next = null;

        return merge(sort(node), sort(midNext));
    }

    public LLNode solve(LLNode node) {
        return sort(node);
    }
}
