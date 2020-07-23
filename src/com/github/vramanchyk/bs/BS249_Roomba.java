package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS249_Roomba {

    public boolean solve(String[] moves, int x, int y) {

        for (String move : moves) {
            if ("NORTH".equals(move)) {
                y--;
            } else if ("SOUTH".equals(move)) {
                y++;
            } else if ("WEST".equals(move)) {
                x++;
            } else if ("EAST".equals(move)) {
                x--;
            }
        }

        return x == 0 && y == 0;
    }
}
