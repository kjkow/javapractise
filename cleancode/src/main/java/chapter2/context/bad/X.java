package chapter2.context.bad;

/**
 * Created by kamil on 2017-08-31.
 */
public class X {

    private void printGuestStatistics(char candidate, int count){
        String number;
        String verb;
        String pluralModifier;
        if(count == 0){
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if(count == 1){
            number = "1";
            verb = "is";
            pluralModifier = "";
        }else {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }
        System.out.println("There" + verb + " " + number + " " + candidate + pluralModifier);
    }
}
