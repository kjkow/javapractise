package lambda.examples;

import lambda.interfaces.DoubleNumericArrayFunction;
import lambda.interfaces.EmptyArrayException;

/**
 * Created by kamil on 2017-10-09.
 */
public class LambdaException {
    public static void main(String[] args) throws EmptyArrayException {
        double[] values = {1.0, 2.0, 3.0, 4.0};

        DoubleNumericArrayFunction average = n -> {
            double sum = 0;

            if(n.length == 0) throw new EmptyArrayException();

            for(int i = 0; i < n.length; i++){
                sum += n[i];
            }

            return sum / n.length;
        };

        System.out.println("average equals " + average.function(values));
        System.out.println("average equals " + average.function(new double[0]));
    }
}
