package com.github.vramanchyk.bs;

import static com.github.vramanchyk.bs.BSUtils.LLNode;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS153_Linked_List_To_Integer {

    public int solve(LLNode node) {
        int result = 0;

        while (node != null) {
            result = result << 1 + node.val;
            node = node.next;
        }

        return result;
    }
}
