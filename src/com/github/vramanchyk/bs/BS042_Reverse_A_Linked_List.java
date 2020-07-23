package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS042_Reverse_A_Linked_List {

    public LLNode solve(LLNode node) {

        LLNode last = null;

        while (node != null) {
            LLNode next = node.next;
            node.next = last;
            last = node;
            node = next;
        }

        return last;
    }
}
