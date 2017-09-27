package lambda.interfaces;

/**
 * Created by kamil on 2017-09-27.
 * Instead of creating NumericFunction and StringFunction interfaces we can use generics and create this
 */
public interface SomeFunction<T> {
    T function (T input);
}
