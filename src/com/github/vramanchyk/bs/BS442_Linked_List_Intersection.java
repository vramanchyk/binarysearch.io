package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS442_Linked_List_Intersection {

    public LLNode solve(LLNode l0, LLNode l1) {
        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        while (l0 != null && l1 != null) {

            if (l0.val == l1.val) {
                LLNode node = new LLNode();
                node.val = l0.val;
                tail.next = node;
                tail = node;

                l0 = l0.next;
                l1 = l1.next;

            } else if (l0.val < l1.val) {
                l0 = l0.next;
            } else {
                l1 = l1.next;
            }
        }

        return dummy.next;
    }
}
