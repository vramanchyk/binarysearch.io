package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS483_Reverse_An_Inner_Linked_List {

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

    public LLNode solve(LLNode node, int i, int j) {
        if (node == null) {
            return null;
        }

        if (i == j) {
            return node;
        }

        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }

        int len = j - i;

        LLNode dummy = new LLNode();
        dummy.next = node;

        LLNode current = dummy;
        while (i > 0) {
            current = current.next;
            i--;
        }

        LLNode to = current.next;

        while (len > 0) {
            to = to.next;
            len--;
        }

        LLNode nextTo = to.next;
        to.next = null;

        LLNode nextCur = current.next;
        current.next = reverse(nextCur);
        nextCur.next = nextTo;

        return dummy.next;
    }
}
