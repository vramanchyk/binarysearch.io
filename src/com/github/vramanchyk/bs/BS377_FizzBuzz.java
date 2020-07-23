package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS377_FizzBuzz {

    public String[] solve(int n) {
        final String[] result = new String[n];

        for (int num = 1; num <= n; num++) {
            if (num % 5 == 0) {
                result[num - 1] = num % 3 == 0 ? "FizzBuzz" : "Buzz";
            } else if (num % 3 == 0) {
                result[num - 1] = "Fizz";
            } else {
                result[num - 1] = ("" + num);
            }
        }

        return result;
    }
}
