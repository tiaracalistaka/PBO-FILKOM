import java.util.Scanner;

class Mobil {
    private String noPlat;
    private String warna;
    private String manufaktur;
    private int kecepatan;
    private double waktu;
    private double jarak;
    public void setNoPlat(String s){
        noPlat = s;
    }
    public void setWarna(String s){
        warna = s;
    }
    public void setManufaktur(String s){
        manufaktur = s;
    }
    public void setKecepatan(int i){kecepatan = i; rubahKecepatan(kecepatan); }
    public void setWaktu(double w){ waktu = w; rubahSekon(waktu);}
    public void rubahSekon(double rubah){
        double waktuSekon = waktu * 3600;
        waktu = waktuSekon;
    }
    public void rubahKecepatan(int i){kecepatan = (int) (kecepatan/ 3.6);}
    public double hitungJarak(){
        jarak = kecepatan * waktu;
        return jarak;}
    public void displayMessage(){
        System.out.println("Mobil anda adalah bermerek "+manufaktur);
        System.out.println("mempunyai nomor plat "+noPlat);
        System.out.println("serta memililki warna "+warna);
        System.out.println("dan mampu menempuh kecepatan "+kecepatan+" m/s");
        System.out.println("Selama " + waktu + " detik");
        System.out.println("dengan jarak yang ditempuh " + hitungJarak() + " meter");
    }
    }

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan jumlah mobil yang ingin dimasukkan : ");
        int jumlahMobil = in.nextInt();
        int pilihan, jenisMobil;
        System.out.println();
        Mobil[] mobil = new Mobil[jumlahMobil];
        for (int i = 0; i < jumlahMobil; i++) {
            System.out.println("=== Informasi Mobil ke - " + (i + 1) + " ===");
            Mobil m = new Mobil();
            System.out.print("Masukkan Kecepatan mobil : ");
            m.setKecepatan(in.nextInt());
            in.nextLine();
            System.out.print("Masukkan Manufaktur mobil : ");
            m.setManufaktur(in.nextLine());
            System.out.print("Masukkan nomor Plat mobil : ");
            m.setNoPlat(in.nextLine());
            System.out.print("Masukkan Warna mobil : ");
            m.setWarna(in.nextLine());
            System.out.print("Masukkan Waktu menaiki mobil(jam) : ");
            m.setWaktu(in.nextDouble());
            //Memasukkan data kedalam array
            mobil[i] = m;
            System.out.println("========================================\n");
        }
        //membuat program looping untuk Informasi Mobil
        for (int i = 0; i < jumlahMobil; i++) {
            System.out.println("=== Informasi Mobil ke - " + (i + 1) + " ===");
            mobil[i].displayMessage();
            System.out.println("========================================\n");
        }
        //merubah Informasi Mobil
        for (int j = 0; j<1;){
            System.out.print("Apakah anda ingin merubah informasi Mobil ?\n1. Iya\n2. Tidak\npilihan : ");
            pilihan = in.nextInt();
            if (pilihan == 1){
                System.out.print("Masukkan nomor mobil yang ingin diubah : ");
                jenisMobil = in.nextInt();
                jenisMobil= jenisMobil - 1;
                System.out.print("Masukkan Kecepatan mobil : ");
                mobil[jenisMobil].setKecepatan(in.nextInt());
                in.nextLine();
                System.out.print("Masukkan Manufaktur mobil : ");
                mobil[jenisMobil].setManufaktur(in.nextLine());
                System.out.print("Masukkan nomor Plat mobil : ");
                mobil[jenisMobil].setNoPlat(in.nextLine());
                System.out.print("Masukkan Warna mobil : ");
                mobil[jenisMobil].setWarna(in.nextLine());
                System.out.println("===============");
            } else {
                for (int i = 0; i < jumlahMobil; i++) {
                    System.out.println("Mobil ke-" + (i));
                    mobil[i].displayMessage();
                    System.out.println("================");
                    j = 1;
                }
            }
        }
    }

}



