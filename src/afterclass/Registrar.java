package afterclass;

import java.util.ArrayList;

public class Registrar {

    /**
     * Drop all courses from Course 6. Modifies courses list by removing
     * courses that start with 6.
     * 
     * @param subjects
     *            list of MIT course numbers
     */
    public static void dropCourse6(ArrayList<String> subjects) {
        // THIS CODE HAS A BUG! See the lecture notes.

        // using MyIterator
        MyIterator iter = new MyIterator(subjects);
        while (iter.hasNext()) {
            String subject = iter.next();
            if (subject.startsWith("6.")) {
                subjects.remove(subject);
            }
        }

//         // using the ArrayList's builtin iterator
//        Iterator<String> iter = subjects.iterator();
//        while (iter.hasNext()) {
//            String subject = iter.next();
//            if (subject.startsWith("6.")) {
//                subjects.remove(subject);
//            }
//        }

//         // using for syntactic sugar
//         for (String subject : subjects) {
//             if (subject.startsWith("6.")) {
//                 subjects.remove(subject);
//             }
//         }
    }

}
