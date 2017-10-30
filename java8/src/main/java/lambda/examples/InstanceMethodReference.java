package lambda.examples;

import lambda.StringOperations;
import lambda.interfaces.StringFunction;

/**
 * Created by kamil on 2017-10-23.
 */
public class InstanceMethodReference {

    static String stringOperation(StringFunction sf, String s){
        return sf.function(s);
    }

    public static void main(String[] args) {
        String input = "input";
        String output;

        StringOperations stringOperations = new StringOperations();

        output = stringOperation(stringOperations::reverseInstanceVersion, input);

        System.out.println(output);
    }
}
