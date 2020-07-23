package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS148_Interleaved_Linked_List {

    public LLNode solve(LLNode l0, LLNode l1) {
        LLNode dummy = new LLNode();
        LLNode last = dummy;

        while (l0 != null && l1 != null) {

            LLNode l0next = l0.next;
            LLNode l1next = l1.next;

            last.next = l0;
            last = last.next;
            last.next = null;

            last.next = l1;
            last = last.next;
            last.next = null;


            l0 = l0next;
            l1 = l1next;
        }

        if (l0 != null) {
            last.next = l0;
        }

        if (l1 != null) {
            last.next = l1;
        }

        return dummy.next;
    }
}
