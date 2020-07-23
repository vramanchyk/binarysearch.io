package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS436_Linked_List_Delete_Last_Occurence {

    public LLNode solve(LLNode node, int target) {

        LLNode head = node;

        LLNode last = null;

        LLNode targetNode = null;
        LLNode targetLast = null;

        while (node != null) {
            if (node.val == target) {
                targetNode = node;
                targetLast = last;
            }

            last = node;
            node = node.next;
        }

        if (targetNode == null) {
            return head;
        }

        if (targetLast == null) {
            return targetNode.next;
        }

        targetLast.next = targetNode.next;
        return head;
    }
}
