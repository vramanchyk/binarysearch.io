package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS189_Reverse_Linked_List_Groups_2 {

    public LLNode solve(LLNode node, int k) {

        LLNode dummy = new LLNode();
        LLNode tail = dummy;
        LLNode cur = node;

        while (cur != null) {
            int group = k;

            LLNode last = null;
            LLNode end = cur;

            while (--group >= 0 && end != null) {
                LLNode groupNext = end.next;
                end.next = last;
                last = end;
                end = groupNext;
            }

            LLNode next = end;

            tail.next = last;
            tail = cur;

            cur = next;
        }

        return dummy.next;
    }
}
