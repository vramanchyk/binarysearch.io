package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Vitali Ramanchyk on 7/19/20.
 */
public class BS308_Tree_Traversal {

    public int solve(Tree root, String[] moves) {
        Deque<Tree> stack = new ArrayDeque<>();

        stack.push(root);
        for (String move : moves) {
            if ("UP".equals(move)) {
                stack.pop();
            } else if ("RIGHT".equals(move)) {
                stack.push(stack.peek().right);
            } else {
                stack.push(stack.peek().left);
            }
        }

        return stack.pop().val;
    }
}
