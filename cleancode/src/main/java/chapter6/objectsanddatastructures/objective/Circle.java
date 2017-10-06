package chapter6.objectsanddatastructures.objective;

import java.awt.*;

/**
 * Created by kamil on 2017-10-03.
 */
public class Circle implements Shape {
    private Point center;
    private double radius;
    public final double PI = 3.14159;

    public double area() {
        return PI * radius * radius;
    }
}
