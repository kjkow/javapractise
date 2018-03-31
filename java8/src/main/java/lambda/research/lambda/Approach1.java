package lambda.research.lambda;

import java.util.List;

/**
 * Created by kamil on 2018-03-31.
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * Approach 1: Create Methods That Search for Members That Match One Characteristic
 * One simplistic approach is to create several methods;
 * each method searches for members that match one characteristic, such as gender or age.
 * The following method prints members that are older than a specified age:
 */
public class Approach1 {

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    /*
      This approach can potentially make your application brittle,
      which is the likelihood of an application not working because of the introduction of updates (such as newer data types).
      Suppose that you upgrade your application and change the structure of the Person class such that it contains different member variables;
      perhaps the class records and measures ages with a different data type or algorithm.
      You would have to rewrite a lot of your API to accommodate this change.
      In addition, this approach is unnecessarily restrictive;
      what if you wanted to print members younger than a certain age, for example?
     */
}
