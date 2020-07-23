package com.github.vramanchyk.bs;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS109_Postfix_Notation_Evaluation {

    public int solve(String[] exp) {
        final Deque<BigInteger> stack = new LinkedList<>();

        for (String str : exp) {
            if ("+".equals(str)) {
                final BigInteger right = stack.pop();
                final BigInteger left = stack.pop();
                stack.push(left.add(right));
            } else if ("-".equals(str)) {
                final BigInteger right = stack.pop();
                final BigInteger left = stack.pop();
                stack.push(left.subtract(right));
            } else if ("*".equals(str)) {
                final BigInteger right = stack.pop();
                final BigInteger left = stack.pop();
                stack.push(left.multiply(right));
            } else if ("/".equals(str)) {
                final BigInteger right = stack.pop();
                final BigInteger left = stack.pop();
                stack.push(left.divide(right));
            } else {
                stack.push(new BigInteger(str));
            }
        }

        return stack.pop().intValue();
    }
}
