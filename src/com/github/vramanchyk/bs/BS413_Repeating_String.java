package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS413_Repeating_String {

    public boolean solve(String s) {
        return ((s + s).indexOf(s, 1) != s.length());
    }
}
