package lambda;

import lambda.interfaces.NumericFunction;

/**
 * Created by kamil on 2017-09-25.
 */
public class BlockLambda {
    public static void main(String[] args) {
        NumericFunction factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        };
        int factorialValue = 5;
        System.out.println("Factorial of number " + factorialValue + " is: " + factorial.function(factorialValue));
    }
}
