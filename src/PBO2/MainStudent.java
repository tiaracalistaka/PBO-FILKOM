package PBO2;

import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah siswa: ");
        int stud = sc.nextInt();

        Student[] student = new Student[stud];

        for (int i = 0; i < stud; i++) {
            System.out.print("Masukkan nama siswa ke-" + (i + 1) + ": ");
            String name = sc.next();
            System.out.print("Masukkan alamat siswa ke-" + (i + 1) + ": ");
            String address = sc.next();
            System.out.print("Masukkan umur siswa ke-" + (i + 1) + ": ");
            int age = sc.nextInt();
            System.out.print("Masukkan nilai matematika siswa ke-" + (i + 1) + ": ");
            double math = sc.nextDouble();
            System.out.print("Masukkan nilai english siswa ke-" + (i + 1) + ": ");
            double english = sc.nextDouble();
            System.out.print("Masukkan nilai science siswa ke-" + (i + 1) + ": ");
            double science = sc.nextDouble();

            student[i] = new Student(name, address, age, math, english, science);
        }


        Student anna = new Student();
        anna.setName("Anna");
        anna.setAddress("Malang");
        anna.setAge(20);
        anna.setMath(100);
        anna.setScience(89);
        anna.setEnglish(80);
        anna.displayMessage();
        // menggunakan constructor lain
        System.out.println("===================");
        Student chris = new Student("Chris", "Kediri", 21,70,60,90);
        chris.displayMessage();
        // siswa dengan nama anna dirubah informasi alamat dan umurnya melalui

        // constructor
        System.out.println("===================");
        anna = new Student("anna", "Batu", 18,70,60,90);
        anna.displayMessage();
        // siswa denagan nama chris dirubah informasi alamat dan umurnya melalui method
        System.out.println("===================");
        chris.setAddress("Surabaya");
        chris.setAge(22);
        chris.displayMessage();

        for (int i = 0; i < stud; i++) {
            System.out.println("\nSiswa ke "+ (i+1));
            student[i].displayMessage();
        }
        sc.close();
    }
}