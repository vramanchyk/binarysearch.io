package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS_Rotate_Linked_List_By_K {

    private LLNode get(LLNode node, int idx) {

        while (idx > 0 && node != null) {
            node = node.next;
            idx--;
        }

        return node;
    }

    public LLNode solve(LLNode node, int k) {

        if (node == null) {
            return null;
        }

        int len = 0;
        LLNode tail = null;
        LLNode cur = node;
        while (cur != null) {
            tail = cur;
            cur = cur.next;
            len++;
        }

        k %= len;
        if (k == 0) {
            return node;
        }

        LLNode newTail = get(node, len - k - 1);
        LLNode newHead = newTail.next;
        newTail.next = null;
        tail.next = node;

        return newHead;
    }
}
