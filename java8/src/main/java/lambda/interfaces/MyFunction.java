package lambda.interfaces;

/**
 * Created by kamil on 2017-10-30.
 */
public interface MyFunction<T> {
    int function(T[] values, T value);
}
