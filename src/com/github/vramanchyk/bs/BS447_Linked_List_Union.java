package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS447_Linked_List_Union {

    private LLNode add(LLNode head, LLNode tail, int val) {
        if (tail == head || tail.val != val) {
            LLNode node = new LLNode();
            node.val = val;
            tail.next = node;
            tail = tail.next;
        }
        return tail;
    }

    public LLNode solve(LLNode ll0, LLNode ll1) {

        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        while (ll0 != null && ll1 != null) {
            if (ll0.val <= ll1.val) {
                tail = add(dummy, tail, ll0.val);
                ll0 = ll0.next;
            } else {
                tail = add(dummy, tail, ll1.val);
                ll1 = ll1.next;
            }
        }

        while (ll0 != null) {
            tail = add(dummy, tail, ll0.val);
            ll0 = ll0.next;
        }

        while (ll1 != null) {
            tail = add(dummy, tail, ll1.val);
            ll1 = ll1.next;
        }

        return dummy.next;
    }
}
