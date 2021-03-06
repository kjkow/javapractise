package lambda.examples;

import lambda.interfaces.NumericTest;
import lambda.interfaces.NumericTest2;

/**
 * Created by kamil on 2017-09-08.
 */
public class ParameterExpression {
    public static void main(String[] args) {
        NumericTest isEven =
                (n) -> (n % 2) == 0;
        System.out.println("Is number 10 even? " + isEven.test(10));

        NumericTest isNonNegative =
                (n) -> n >= 0;
        System.out.println("Is -9 not a negative number? " + isNonNegative.test(-9));

        NumericTest2 isFactor =
                (n, d) -> (n % d) == 0;

        System.out.println("2 is factor of 10: " + isFactor.test(10,2));
    }
}
