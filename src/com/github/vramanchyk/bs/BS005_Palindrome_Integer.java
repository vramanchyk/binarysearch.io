package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/26/20.
 */
public class BS005_Palindrome_Integer {

    public boolean solve(int num) {
        if (num < 10) {
            return true;
        }

        int tmp = num;
        int count = 0;
        while (tmp > 0) {
            count++;
            tmp /= 10;
        }

        boolean odd = count % 2 == 1;
        count /= 2;

        tmp = 0;
        while (count-- > 0) {
            tmp = tmp * 10 + num % 10;
            num /= 10;
        }

        return tmp == (odd ? num / 10 : num);
    }
}
