package chapter2.factory;

/**
 * Created by kamil on 2017-08-31.
 */
public class Complex {

    private Complex(){}

    public static Complex FromRealNumber(double number){
        Complex c = new Complex();
        return c;
    }
}
