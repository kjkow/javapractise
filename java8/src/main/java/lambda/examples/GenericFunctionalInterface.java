package lambda.examples;

import lambda.interfaces.SomeFunction;

/**
 * Created by kamil on 2017-09-27.
 */
public class GenericFunctionalInterface {

    static String wordToReverse = "Capitalism";

    public static void main(String[] args) {
        SomeFunction<String> reverse = input -> {
           int index;
           StringBuilder builder = new StringBuilder();

            for (index = input.length()-1; index >= 0; index--) {
                builder.append(input.charAt(index));
            }
            return builder.toString();
        };

        System.out.println("Reversed word " + wordToReverse + " is: " + reverse.function(wordToReverse));
    }
}
