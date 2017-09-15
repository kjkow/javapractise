package chapter4;

/**
 * Created by kamil on 2017-09-07.
 */
public class Example {
    public static void main(String[] args) {

        /**
         * bad
         */
        //Check if employee is eligable for full benefits
        //if((employee.flags & HOURLY_FLAG) && employee.age > 65)){}

        /**
         * good
         */
        //if(employee.isEligibleForFullBenefits()){}
    }
}
