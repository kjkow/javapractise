package lambda;

import lambda.interfaces.StringFunction;

/**
 * Created by kamil on 2017-10-05.
 */
public class LambdaAsArgument {
    static String stringOperation(StringFunction sf, String s){
        return sf.function(s);
    }

    public static void main(String[] args) {
        String string = stringOperation(
                ((str) -> {return str.toUpperCase();}),
                "test"
        );

        StringFunction lowerCase = str -> str.toLowerCase();
        stringOperation(lowerCase, "TEST");

    }
}
