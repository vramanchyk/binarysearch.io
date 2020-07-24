package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS101_List_Partitioning {

    public String[] solve(String[] strs) {

        int red = 0, green = 0, blue = 0;
        for (String str : strs) {
            if ("red".equals(str)) {
                red++;
            } else if ("green".equals(str)) {
                green++;
            } else {
                blue++;
            }
        }

        int cursor = 0;

        while (red-- > 0) {
            strs[cursor++] = "red";
        }

        while (green-- > 0) {
            strs[cursor++] = "green";
        }

        while (blue-- > 0) {
            strs[cursor++] = "blue";
        }

        return strs;
    }
}
