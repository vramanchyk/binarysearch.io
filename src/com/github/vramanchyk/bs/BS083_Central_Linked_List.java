package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS083_Central_Linked_List {

    public int solve(LLNode node) {
        LLNode cur = node;
        LLNode fast = cur;

        while (fast != null && fast.next != null) {
            cur = cur.next;
            fast = fast.next.next;
        }

        return cur.val;
    }
}
