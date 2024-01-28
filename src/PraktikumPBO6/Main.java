package PraktikumPBO6;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("NOMER 1");
        Manusia a = new Manusia("A", true, "111", true);
        System.out.println(a);
        Manusia b = new Manusia("B", false, "112", true);
        System.out.println(b);
        Manusia c = new Manusia("C", true, "113", false);
        System.out.println(c);
        System.out.println("NOMER 2");
        MahasiswaFILKOM d = new MahasiswaFILKOM("D",  false, "123", false, "225150200111100", 2.9);
        System.out.println(d);
        MahasiswaFILKOM e = new MahasiswaFILKOM("E",  false, "124", false, "22515020111100", 3.3);
        System.out.println(e);
        MahasiswaFILKOM f = new MahasiswaFILKOM("F",  false, "125", false, "225150200111100", 4.0);
        System.out.println(f);
        System.out.println("NOMER 3");
        Pekerja g = new Pekerja("G", true, "134", true, 1000, LocalDate.of(2021, 2, 3), 2);
        System.out.println(g);
        Pekerja h = new Pekerja("H", true, "135", true, 1000, LocalDate.of(2014, 2, 3), 0);
        System.out.println(h);
        Pekerja i = new Pekerja("I", true, "136", true, 1000, LocalDate.of(2003, 2, 3), 10);
        System.out.println(i);
        System.out.println("NOMER 4");
        Manager j = new Manager("J", true,  "222", true, 7500, LocalDate.of(2008, 2, 3), 0, "HRD");
        System.out.println(j);

    }

}
