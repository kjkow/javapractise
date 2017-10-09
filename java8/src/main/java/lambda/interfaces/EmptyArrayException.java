package lambda.interfaces;

/**
 * Created by kamil on 2017-10-09.
 */
public class EmptyArrayException extends Exception {
    public EmptyArrayException(){
        super("Array is empty.");
    }
}
