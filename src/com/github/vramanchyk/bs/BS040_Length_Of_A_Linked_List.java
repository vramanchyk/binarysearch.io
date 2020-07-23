package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS040_Length_Of_A_Linked_List {

    public int solve(LLNode node) {
        int result = 0;

        while (node != null) {
            result++;
            node = node.next;
        }

        return result;
    }
}
