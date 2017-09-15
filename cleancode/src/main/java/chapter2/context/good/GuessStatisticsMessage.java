package chapter2.context.good;

/**
 * Created by kamil on 2017-08-31.
 */
public class GuessStatisticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count){
        createPluralDependentMessegeParts(count);
        return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
    }

    private void createPluralDependentMessegeParts(int count){
        if(count == 0){
            thereAreNoLetters();
        } else if(count == 1){
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreManyLetters(int count){
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter(){
        number = "1";
        verb = "is";
        pluralModifier = " ";
    }

    private void thereAreNoLetters(){
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }
}
