package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS258_Add_Linked_Lists {

    public LLNode solve(LLNode l0, LLNode l1) {
        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        int overflow = 0;
        while (overflow != 0 || l0 != null || l1 != null) {
            int current = overflow + (l0 == null ? 0 : l0.val) + (l1 == null ? 0 : l1.val);
            overflow = current / 10;

            final LLNode node = new LLNode();
            node.val = current % 10;
            tail.next = node;
            tail = tail.next;

            l0 = l0 == null ? null : l0.next;
            l1 = l1 == null ? null : l1.next;
        }

        return dummy.next;
    }
}
