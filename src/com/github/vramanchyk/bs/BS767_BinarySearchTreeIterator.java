package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 11/18/20.
 */
public class BS767_BinarySearchTreeIterator {

    private void traverse(Tree root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            traverse(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            traverse(root.right, list);
        }
    }

    private final Iterator<Integer> it;

    public BS767_BinarySearchTreeIterator(Tree root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        it = list.iterator();
    }

    public int next() {
        return it.next();
    }

    public boolean hasnext() {
        return it.hasNext();
    }
}
