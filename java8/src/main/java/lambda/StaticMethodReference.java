package lambda;

import lambda.interfaces.StringFunction;

/**
 * Created by kamil on 2017-10-17.
 */
public class StaticMethodReference {

    static String stringOperation(StringFunction stringFunction, String input){
        return stringFunction.function(input);
    }

    public static void main(String[] args) {
        String input = "Anne has a cat";
        String output = stringOperation(StringOperations::reverse, input); //pretty cool right?

        System.out.println(output);
    }
}
