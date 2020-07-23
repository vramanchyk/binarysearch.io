package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS061_Hip_To_Be_Square {

    public int[] solve(int[] nums) {
        final int len = nums.length;

        int negativeIndex = 0;
        int positiveIndex = 0;

        while (negativeIndex < len && nums[negativeIndex] < 0) {
            negativeIndex++;
        }

        positiveIndex = negativeIndex;
        negativeIndex--;

        final int[] result = new int[len];
        int cursor = 0;

        for (int index = 0; index < len; index++) {
            if (negativeIndex >= 0 && positiveIndex < len) {
                int sqNeg = nums[negativeIndex] * nums[negativeIndex];
                int sqPos = nums[positiveIndex] * nums[positiveIndex];

                if (sqNeg < sqPos) {
                    result[index] = sqNeg;
                    negativeIndex--;
                } else {
                    result[index] = sqPos;
                    positiveIndex++;
                }
            } else if (negativeIndex >= 0) {
                result[index] = nums[negativeIndex] * nums[negativeIndex];
                negativeIndex--;
            } else {
                result[index] = nums[positiveIndex] * nums[positiveIndex];
                positiveIndex++;
            }
        }

        return result;
    }
}
