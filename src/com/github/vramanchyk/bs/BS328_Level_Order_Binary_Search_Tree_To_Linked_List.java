package com.github.vramanchyk.bs;

import java.util.LinkedList;
import java.util.Queue;

import static com.github.vramanchyk.bs.BSUtils.LLNode;
import static com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS328_Level_Order_Binary_Search_Tree_To_Linked_List {

    public LLNode solve(Tree root) {
        if (root == null) {
            return null;
        }

        LLNode dummy = new LLNode();
        LLNode tail = dummy;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        int l = 0;
        while (l < queue.size()) {
            int levelCount = queue.size();

            for (int index = 0; index < levelCount; index++) {
                Tree node = queue.poll();

                LLNode listNode = new LLNode();
                listNode.val = node.val;
                tail.next = listNode;
                tail = listNode;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }
        }

        return dummy.next;
    }
}
