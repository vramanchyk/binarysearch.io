package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS043_Palindrome_Linked_List {

    private LLNode mid(LLNode node) {
        LLNode fast = node;

        while (fast != null && fast.next != null) {
            node = node.next;
            fast = fast.next.next;
        }

        return node;
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

    private int length(LLNode node) {
        int length = 0;

        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

    private boolean areEqual(LLNode a, LLNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            }

            a = a.next;
            b = b.next;
        }

        return a == null && b == null;
    }

    public boolean solve(LLNode node) {
        LLNode mid = mid(node);

        LLNode next = mid.next;
        mid.next = null;

        LLNode rev = reverse(node);

        if ((length(rev) + length(next)) % 2 != 0) {
            return areEqual(rev.next, next);
        }

        if (rev.val != rev.next.val) {
            return false;
        }

        return areEqual(rev.next.next, next);
    }
}