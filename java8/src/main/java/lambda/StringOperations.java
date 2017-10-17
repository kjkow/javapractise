package lambda;

/**
 * Created by kamil on 2017-10-17.
 */
public class StringOperations {

    static String reverse(String input){
        StringBuilder result = new StringBuilder();

        for (int i = input.length()-1; i >=0; i--) {
            result.append(input.charAt(i));
        }

        return result.toString();
    }
}
