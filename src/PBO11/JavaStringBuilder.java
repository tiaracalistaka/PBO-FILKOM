package PBO11;

public class JavaStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity());
        System.out.println(sb.toString());
        StringBuilder sb1 = new StringBuilder(1000);
        System.out.println(sb1.capacity());
        System.out.println(sb1.toString());
        StringBuilder sb2 = new StringBuilder("Java");
        System.out.println(sb2.capacity());
        System.out.println(sb2.toString());
        CharSequence seq = new StringBuilder("String");
        StringBuilder sb3 = new StringBuilder(seq);
        System.out.println(sb3.capacity());
        System.out.println(sb3.toString());
        sb3.append(" Java");
        System.out.println(sb3.toString() + sb3.capacity());
        sb3.insert(11, " Builder");
        System.out.println(sb3.toString() + sb3.capacity());
        System.out.println(sb3.compareTo(sb2));
        System.out.println(sb3.equals(sb2));
        System.out.println(sb3.charAt(2));
        System.out.println(sb3.substring(3));
        System.out.println(sb3.length());
        System.out.println(sb3.reverse());
        }
}
