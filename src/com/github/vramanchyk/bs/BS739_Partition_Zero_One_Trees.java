package com.github.vramanchyk.bs;

import com.github.vramanchyk.bs.BSUtils.Tree;

/**
 * Created by Vitali Ramanchyk on 9/14/20.
 */
public class BS739_Partition_Zero_One_Trees {

    private void count(Tree root, int[] counts) {
        if (root == null) {
            return;
        }

        if (root.val == 0) {
            counts[0]++;
        } else if (root.val == 1) {
            counts[1]++;
        }

        count(root.left, counts);
        count(root.right, counts);
    }

    private int[] traverse(Tree root, int[] counts, int[] val) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] res = new int[2];

        if (root.val == 0) {
            res[0]++;
        } else if (root.val == 1) {
            res[1]++;
        }

        if (root.left == null && root.right == null) {
            return res;
        }

        int[] l = traverse(root.left, counts, val);
        int[] r = traverse(root.right, counts, val);

        if (root.left != null) {
            int zL = l[0];
            int oL = l[1];

            int zR = counts[0] - zL;
            int oR = counts[1] - oL;

            if (!((zL > 0 && oL > 0) || (zR > 0 && oR > 0))) {
                val[0]++;
            }
        }

        if (root.right != null) {
            int zR = r[0];
            int oR = r[1];

            int zL = counts[0] - zR;
            int oL = counts[1] - oR;

            if (!((zL > 0 && oL > 0) || (zR > 0 && oR > 0))) {
                val[0]++;
            }
        }

        res[0] += (l[0] + r[0]);
        res[1] += (l[1] + r[1]);

        return res;
    }

    public int solve(Tree root) {
        if (root == null) {
            return 0;
        }

        int[] counts = new int[2];
        count(root, counts);

        int[] val = new int[1];
        traverse(root, counts, val);

        return val[0];
    }
}
