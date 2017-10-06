package chapter6.objectsanddatastructures.procedural;



/**
 * Created by kamil on 2017-10-03.
 * Square, Rectangle and Circle are data structures - they have only data and no functions
 * Geometry is an object, hides data and gives functions to manipulate them
 * This is procedural approach, its easier to add new functions without changing data structures
 * also its harder to add new data structures because one must change every function
 */
public class Geometry {
    public final double PI = 3.14159;

    public double area(Object shape) throws NoSuchShapeException {
        if(shape instanceof Square){
            Square s = (Square) shape;
            return s.side * s.side;
        }
        else if (shape instanceof Rectangle){
            Rectangle r = (Rectangle) shape;
            return r.height * r.width;
        }
        else if (shape instanceof Circle){
            Circle c = (Circle) shape;
            return PI * c.radius * c.radius;
        }
        throw new NoSuchShapeException();
    }

}
