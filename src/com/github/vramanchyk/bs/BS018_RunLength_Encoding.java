package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS018_RunLength_Encoding {

    public String solve(String s) {

        char last = 0;
        int lastCount = 0;

        StringBuilder bld = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != last) {

                if (lastCount > 0) {
                    bld.append(lastCount).append(last);
                }

                lastCount = 0;
            }

            last = ch;
            lastCount++;
        }

        if (lastCount > 0) {
            bld.append(lastCount).append(last);
        }

        return bld.toString();
    }
}
