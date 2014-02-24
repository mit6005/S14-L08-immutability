package afterclass;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class RegistrarTest {
    // Testing strategy:
    // subjects.size: 0, 1, n
    // contents: no 6.xx, one 6.xx, all 6.xx
    // position: 6.xx at start, 6.xx in middle, 6.xx at end

    @Test
    // covers subjects.size=0
    public void emptyList() {
        ArrayList<String> subjects = new ArrayList<String>();
        Registrar.dropCourse6(subjects);
        assertEquals(new ArrayList<Integer>(), subjects);
    }

    @Test
    // covers subjects.size=1, no 6.xx
    public void oneClassNotCourse6() {
        ArrayList<String> subjects = new ArrayList<String>(
                Arrays.asList(new String[] { "8.03" }));
        Registrar.dropCourse6(subjects);
        assertEquals(
                new ArrayList<String>(Arrays.asList(new String[] { "8.03" })),
                subjects);
    }

    @Test
    // covers subjects.size=n, no 6.xx
    public void severalClassesNotCourse6() {
        ArrayList<String> subjects = new ArrayList<String>(
                Arrays.asList(new String[] { "14.03", "9.00", "21L.005" }));
        Registrar.dropCourse6(subjects);
        assertEquals(
                new ArrayList<String>(Arrays.asList(new String[] { "14.03",
                        "9.00", "21L.005" })), subjects);
    }

    @Test
    // covers subjects.size=n, one 6.xx, 6.xx in middle
    public void severalClassesMiddleCourse6() {
        ArrayList<String> subjects = new ArrayList<String>(
                Arrays.asList(new String[] { "2.001", "6.01", "18.03" }));
        Registrar.dropCourse6(subjects);
        assertEquals(
                new ArrayList<String>(Arrays.asList(new String[] { "2.001",
                        "18.03" })), subjects);
    }

    @Test
    // covers subjects.size=n, all 6.xx, 6.xx at start, 6.xx at end
    public void severalClassesAllCourse6() {
        ArrayList<String> subjects = new ArrayList<String>(
                Arrays.asList(new String[] { "6.045", "6.005", "6.813" }));
        Registrar.dropCourse6(subjects);
        System.out.println(subjects);
        assertEquals(new ArrayList<Integer>(), subjects);
    }
}
