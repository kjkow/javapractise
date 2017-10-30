package lambda.operations;

/**
 * Created by kamil on 2017-10-30.
 */
public class ArrayOperations {
    public static <T> int countMatching(T[] values, T value){
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] == value) count++;
        }
        return count;
    }
}
