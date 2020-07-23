package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BSUtils {

    public static class Tree {

        int val;

        Tree left;

        Tree right;

        public Tree() {
        }

        public Tree(int val) {
            this.val = val;
        }
    }

    public static class LLNode {

        int val;

        LLNode next;

        public LLNode(int val) {
            this.val = val;
        }

        public LLNode() {
        }
    }

    public static LLNode list(int... values) {
        LLNode dummy = new LLNode();
        LLNode tail = dummy;
        for (int val : values) {
            tail.next = new LLNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }
}
