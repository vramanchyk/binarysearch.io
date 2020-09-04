package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/4/20.
 */
public class BS492_Number_Of_Unique_Char_Substrings {

    public int solve(String s) {

        int cur = 0;
        int ans = 0;
        while (cur < s.length()) {
            char ch = s.charAt(cur);
            int idx = cur;

            int cnt = 0;
            while (idx < s.length() && s.charAt(idx) == ch) {
                cnt++;
                idx++;
            }

            ans += cnt * (cnt + 1) / 2;
            cur = idx;
        }

        return ans;
    }
}
