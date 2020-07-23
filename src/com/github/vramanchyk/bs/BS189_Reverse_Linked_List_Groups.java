package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS189_Reverse_Linked_List_Groups {

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

    public LLNode solve(LLNode node, int k) {

        LLNode dummy = new LLNode();
        LLNode tail = dummy;
        LLNode cur = node;

        while (cur != null) {
            int group = k;

            LLNode start = cur;
            LLNode end = cur;

            while (--group > 0 && end.next != null) {
                end = end.next;
            }

            LLNode next = end.next;

            end.next = null;
            tail.next = reverse(start);
            tail = start;

            cur = next;
        }

        return dummy.next;
    }
}
