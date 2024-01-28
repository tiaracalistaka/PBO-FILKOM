package PBO11;
import java.util.Iterator;
import java.util.StringTokenizer;

public class JavaStringTokenizer {
    public static void main(String[] args) {
        String csv = "Java,Python,Android";
        StringTokenizer st = new StringTokenizer(csv, ",");
        printTokens(st);
        String line = "Welcome to JavaString.net\nLearn\tJava\tProgramming";
        StringTokenizer st1 = new StringTokenizer(line);
        printTokens(st1);
        StringTokenizer st2 = new StringTokenizer("Hi Hello Yes");
        System.out.println(st2.countTokens());
        st2.nextToken();
        System.out.println(st2.countTokens());
        StringTokenizer st3 = new StringTokenizer("Hi|Hello|Yes", "|", true);
        System.out.println(st3.countTokens());
        printTokens(st3);
        StringTokenizer st4 = new StringTokenizer("Hello Java World");
        Iterator<Object> iterator = st4.asIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    private static void printTokens(StringTokenizer st) {
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
