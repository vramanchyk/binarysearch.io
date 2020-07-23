package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS041_Kth_Last_Node_Of_A_Linked_List {

    public int solve(LLNode node, int k) {

        LLNode kth = node;
        while (k > 0) {
            kth = kth.next;
            k--;
        }

        while (kth != null && kth.next != null) {
            node = node.next;
            kth = kth.next;
        }

        return node.val;
    }
}
