package com.github.vramanchyk.bs;

import java.math.BigInteger;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS336_Distinct_Palindromes {

    private final int MOD = 1_000_000_007;

    private BigInteger fact(int k) {
        BigInteger result = BigInteger.ONE;

        for (int f = 2; f <= k; f++) {
            result = result.multiply(BigInteger.valueOf(f));
        }

        return result;
    }

    public int solve(String s) {
        int[] counts = new int[26];
        s.chars().forEach(ch -> counts[ch - 'a']++);

        int sum = 0;
        int oddCount = 0;
        for (int count : counts) {
            sum += count;
            oddCount += count % 2 == 1 ? 1 : 0;
        }

        if (oddCount > 1) {
            return 0;
        }

        for (int index = 0; index < 26; index++) {
            counts[index] /= 2;
        }

        sum /= 2;

        BigInteger low = BigInteger.ONE;
        for (int index = 0; index < 26; index++) {
            if (counts[index] > 0) {
                low = low.multiply(fact(counts[index]));
            }
        }

        return fact(sum).divide(low).mod(BigInteger.valueOf(MOD)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new BS336_Distinct_Palindromes().solve("hofichorydrtfhofichorydrtf"));
    }
}
