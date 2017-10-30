package lambda.examples;

import lambda.ArrayOperations;
import lambda.interfaces.MyFunction;

/**
 * Created by kamil on 2017-10-30.
 */
public class GenericMethodReference {

    public static <T> int operation(MyFunction<T> function, T[] values, T value){
        return function.function(values, value);
    }

    public static void main(String[] args) {
        Integer[] values = {1,2,3,4,2,3,4,4,5};
        int count;

        count = operation(ArrayOperations::countMatching, values, 4); //no need for <Integer> before method
        System.out.println("Vals array contains " + count + " of number 4");

    }
}
