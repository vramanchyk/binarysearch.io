package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS375_Linked_List_Folding {

    private LLNode merge(LLNode a, LLNode b) {
        LLNode head = b;

        while (a != null && b != null) {
            b.val += a.val;
            a = a.next;
            b = b.next;
        }

        return head;
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

    public LLNode solve(LLNode node) {

        LLNode last = null;
        LLNode fast = node;
        LLNode cur = node;

        while (fast != null && fast.next != null) {
            last = cur;
            cur = cur.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            last.next = null;
            return merge(reverse(node), cur);
        }

        last.next = null;
        cur.next = merge(reverse(node), cur.next);

        return cur;
    }
}
