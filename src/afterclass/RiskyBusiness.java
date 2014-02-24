package afterclass;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SuppressWarnings("deprecation") // bad idea in general! but keeps this example simple
public class RiskyBusiness {

    //
    // Risky example #1: passing mutable objects
    //
    
    /** @return the sum of the numbers in the list */
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int x : list) sum += x;
        return sum;
    }
    
    /** @return the sum of the absolute values of the numbers in the list */
    public static int sumAbsolute(List<Integer> list) {
        // let's reuse sum(), because DRY. So first we take absolute values.
        for (int i = 0; i < list.size(); ++i) list.set(i, Math.abs(list.get(i)));
        return sum(list);
    }

    // meanwhile, somewhere else in the code...
    public static void main(String[] args) {
        // ...
        List<Integer> myData = Arrays.asList(-5, -3, -2);
        System.out.println(sumAbsolute(myData));
        System.out.println(sum(myData));
    }
    
    
    //
    // Risky example #2: returning mutable objects
    //
    
    /** @return the first day of spring this year */
    public static Date startOfSpring() {
        if (groundhogAnswer == null) groundhogAnswer = askGroundhog();
        return groundhogAnswer;
    }
    private static Date groundhogAnswer = null; 
    
    
    // somewhere else in the code...
    public static void partyPlanning() {
        // let's have a party one month after spring starts!
        Date partyDate = startOfSpring();
        partyDate.setMonth(partyDate.getMonth() + 1);
        // ... uh-oh. what just happened?
    }
    
    
    
    
    
    
    
    // The method implementations below aren't critical to the examples.
    // They just allow the examples to compile without errors.
    private static Date askGroundhog() {
        Calendar calendar = Calendar.getInstance();
        if (new Random().nextBoolean()) {
            // six more weeks of winter
            calendar.roll(Calendar.WEEK_OF_YEAR, 6);
        } else {
            calendar.set(Calendar.MONTH, Calendar.MARCH);
            calendar.set(Calendar.DAY_OF_MONTH, 21);
        }
        return calendar.getTime();
    }

}
