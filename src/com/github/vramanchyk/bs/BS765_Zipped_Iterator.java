package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 11/17/20.
 */
public class BS765_Zipped_Iterator {

    private final int[] a;

    private final int[] b;

    private int colA = 0;

    private int colB = 0;

    private int turn = 0;

    public BS765_Zipped_Iterator(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    public int next() {
        int result = 0;

        if (turn == 0) {
            if (colA < a.length) {
                result = a[colA++];
            } else {
                result = b[colB++];
            }
        } else {
            if (colB < b.length) {
                result = b[colB++];
            } else {
                result = a[colA++];
            }
        }

        turn ^= 1;
        return result;
    }

    public boolean hasnext() {
        return colA < a.length || colB < b.length;
    }
}
