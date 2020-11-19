package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 11/18/20.
 */
public class BS771_PeekableIterator {

    private int cursor;

    private final int[] nums;

    public BS771_PeekableIterator(int[] nums) {
        this.nums = nums;
        this.cursor = 0;
    }

    public int peek() {
        return nums[cursor];
    }

    public int next() {
        return nums[cursor++];
    }

    public boolean hasnext() {
        return cursor < nums.length;
    }
}
