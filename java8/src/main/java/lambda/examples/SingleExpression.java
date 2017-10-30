package lambda.examples;

import lambda.interfaces.DoubleValue;

/**
 * Created by kamil on 2017-09-08.
 */
public class SingleExpression {
    public static void main(String[] args) {
        DoubleValue doubleConstant;
        doubleConstant = () -> 30.55;
        System.out.println(doubleConstant.getValue());

        DoubleValue doubleRandom = () -> Math.random() * 100;
        System.out.println(doubleRandom.getValue());
    }
}
