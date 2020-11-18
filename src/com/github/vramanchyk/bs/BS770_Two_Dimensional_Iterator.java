package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 11/17/20.
 */
public class BS770_Two_Dimensional_Iterator {

    private int row = 0;

    private int col = 0;

    private int[][] data;

    public BS770_Two_Dimensional_Iterator(int[][] lists) {
        this.data = lists;
    }

    public int next() {
        skipEmpty();
        return data[row][col++];
    }

    public boolean hasnext() {
        skipEmpty();
        return row < data.length && col < data[row].length;
    }

    private void skipEmpty() {
        while (row < data.length && col >= data[row].length) {
            row++;
            col = 0;
        }
    }
}
