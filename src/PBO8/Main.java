package PBO8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukan nama anda : ");
        String nama = in.nextLine();
        System.out.println("Masukan umur anda : ");
        int umur = in.nextInt();
        Manusia a = new Manusia(nama, umur);
        Hewan kucing = new Hewan("Kucing", 4);
        kucing.berjalan();
        kucing.bersuara();

    }
}
