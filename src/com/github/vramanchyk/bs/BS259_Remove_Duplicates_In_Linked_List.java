package com.github.vramanchyk.bs;

import java.util.HashSet;
import java.util.Set;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS259_Remove_Duplicates_In_Linked_List {

    public LLNode solve(LLNode node) {
        final Set<Integer> visited = new HashSet<>();

        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        while (node != null) {
            LLNode next = node.next;

            if (visited.add(node.val)) {
                tail.next = node;
                tail = tail.next;
                tail.next = null;
            }

            node = next;
        }

        return dummy.next;
    }
}
