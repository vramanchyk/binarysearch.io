package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS202_Make_Lists_Same {

    public int solve(int[] a, int[] b) {
        int la = 0, lb = 0;

        int count = 0;
        while (la < a.length && lb < b.length) {
            if (a[la] == b[lb]) {
                la++;
                lb++;
                count++;
            } else if (a[la] < b[lb]) {
                if (la + 1 < a.length) {
                    a[la + 1] += a[la++];
                } else {
                    return -1;
                }
            } else {
                if (lb + 1 < b.length) {
                    b[lb + 1] += b[lb++];
                } else {
                    return -1;
                }
            }
        }

        return la == a.length && lb == b.length ? count : -1;
    }
}
