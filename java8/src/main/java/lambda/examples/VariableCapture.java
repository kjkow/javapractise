package lambda.examples;

import chapter2.context.good.GuessStatisticsMessage;
import lambda.interfaces.NumericFunction;
import lambda.interfaces.SomeFunction;

/**
 * Created by kamil on 2017-10-11.
 */
public class VariableCapture {
    static GuessStatisticsMessage guessStatisticsMessage = new GuessStatisticsMessage();
    public static void main(String[] args) {
        int number = 10; //local variable that can be captured

        NumericFunction lambda = n -> {
            //this is right way to use variable number
            //we don't change it

            return number + n;

            //so number is practically finalized here and we can't modify that variable:
            //Error:(15, 13) java: local variables referenced from a lambda expression must be final or effectively final
        };


        SomeFunction<String> stringLambda = n -> {
          guessStatisticsMessage = new GuessStatisticsMessage(); //we can change however variables of this class (static doesn't matter here)
          return guessStatisticsMessage.make('c',1);
        };
    }
}
