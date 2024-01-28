package UAP;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Tanaman implements Perawatan {
    private String namaBuah;
    private int masaHidup;
    private int lamaHidup;
    private int berbuah;
    private int buah;
    private double perkembangan;
    private double prosesBerbuah;

    public String getNamaBuah() {
        return namaBuah;
    }

    public void setNamaBuah(String namaBuah) {
        this.namaBuah = namaBuah;
    }

    public int getMasaHidup() {
        return masaHidup;
    }

    public void setMasaHidup(int masaHidup) {
        this.masaHidup = masaHidup;
    }

    public int getLamaHidup() {
        return lamaHidup;
    }

    public void setLamaHidup(int lamaHidup) {
        this.lamaHidup = lamaHidup;
    }

    public double getBerbuah() {
        return berbuah;
    }

    public void setBerbuah(int berbuah) {
        this.berbuah = berbuah;
    }

    public int getBuah() {
        return buah;
    }

    public void setBuah(int buah) {
        this.buah = buah;
    }

    public double getPerkembangan() {
        return perkembangan;
    }

    public void setPerkembangan(double perkembangan) {
        this.perkembangan = perkembangan;
    }

    public double getProsesBerbuah() {
        return prosesBerbuah;
    }

    public void setProsesBerbuah(double prosesBerbuah) {
        this.prosesBerbuah = prosesBerbuah;
    }

    public abstract void berkembang();

    public String status(){
        if(lamaHidup >= masaHidup){
            return "Mati";
        }
        return "Hidup";
    }

    @Override
    public String toString() {
        return "Masa Hidup\t: " + getMasaHidup() + " Hari"
                +"\nUmur Tanaman\t: " + getLamaHidup()+ " Hari"
                +"\nMenghasilkan\t: " + getBuah() + " buah " + getNamaBuah()
                + "\nStatus\t\t: " + status();
    }
}
interface Perawatan {
    public void treatment();
}
class Tomat extends Tanaman implements Perawatan {
    public Tomat(){
        setMasaHidup(100);
        setBerbuah(100);
        setPerkembangan(0.25);
        setNamaBuah("Tomat");
    }

    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 0.05);
    }

    @Override
    public void berkembang() {
        setProsesBerbuah(getProsesBerbuah() + getBerbuah() * getPerkembangan());
        if (getProsesBerbuah() >= getBerbuah()){
            setBuah(getBuah()+1);
            setProsesBerbuah(getProsesBerbuah()-getBerbuah());
        }
        setLamaHidup(getLamaHidup()+1);
    }
}
class Stroberi extends Tanaman implements Perawatan{
    public Stroberi() {
        setMasaHidup(60);
        setBerbuah(150);
        setPerkembangan(0.35);
        setNamaBuah("Stroberi");
    }

    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 0.05);
    }

    @Override
    public void berkembang() {
        setProsesBerbuah(getProsesBerbuah() + getBerbuah() * getPerkembangan());
        if (getProsesBerbuah() >= getBerbuah()){
            setBuah(getBuah()+1);
            setProsesBerbuah(getProsesBerbuah()-getBerbuah());
        }
        setLamaHidup(getLamaHidup()+1);
    }
}
class Persik extends Tanaman implements Perawatan{
    public Persik() {
        setMasaHidup(180);
        setBerbuah(250);
        setPerkembangan(0.15);
        setNamaBuah("Persik");
    }
    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 0.025);
    }

    @Override
    public void berkembang() {
        setProsesBerbuah(getProsesBerbuah() + getBerbuah() * getPerkembangan());
        if (getProsesBerbuah() >= getBerbuah()){
            setBuah(getBuah()+1);
            setProsesBerbuah(getProsesBerbuah()-getBerbuah());
        }
        setLamaHidup(getLamaHidup()+1);
    }
}
class Data {
    public static ArrayList<Tanaman> tanamans;
    public static ArrayList<Integer> lokasi;
    public static Scanner in;
    private static String namaMati;

    public static void mulai(){
        tanamans = new ArrayList<>();
        lokasi = new ArrayList<>();
        in = new Scanner(System.in);
        namaMati = "";
        System.out.print("Masa tanam (bulan): ");
        int masaTanam = toDay(in.nextInt());

        for (int i = 0; i < 3; i++) {
            menanam();
        }

        System.out.println("--------------------");
        System.out.println("PROSES PERKEMBANGAN");
        System.out.println("--------------------");


        for (int hari = 0; hari < masaTanam; hari++) {
            if (hari % 90 == 0 && hari != 0){
                System.out.println("--------------------");
                System.out.println("DILAKUKAN PERAWATAN");
                System.out.println("--------------------");
                for (int i = 0; i < tanamans.size(); i++){
                    if (lokasi.contains(i)) continue;
                    tanamans.get(i).treatment();
                }
            }
            for (int i = 0; i < tanamans.size(); i++){
                if (tanamans.get(i).status().equals("Hidup")){
                    tanamans.get(i).berkembang();
                } else if (lokasi.contains(i)){
                    continue;
                } else if (tanamans.get(i).status().equals("Mati")){
                    lokasi.add(i);
                    switch (tanamans.get(i).getNamaBuah()){
                        case "Tomat" -> namaMati = "Tomat";
                        case "Stroberi" -> namaMati = "Stroberi";
                        case "Persik" -> namaMati = "Persik";
                    }
                    System.out.println("Tanaman " + namaMati + " telah mati.");
                    menanam();
                }
            }
        }
    }
    public static void menanam(){
        int pilihan;
        System.out.println("Mau menanam apa ?");
        System.out.println("1. Tomat\n2. Stroberi\n3. Persik");
        pilihan = in.nextInt();
        switch (pilihan){
            case 1 -> {
                Tomat t = new Tomat();
                tanamans.add(t);
                System.out.println("Tomat berhasil ditanam.");
            }
            case 2 -> {
                Stroberi s = new Stroberi();
                tanamans.add(s);
                System.out.println("Stroberi berhasil ditanam.");
            }
            case 3 -> {
                Persik p = new Persik();
                tanamans.add(p);
                System.out.println("Persik berhasil ditanam.");
            }
        }
    }
    public static void info(){
        System.out.println( "------" + "HASIL MENANAM" + "------");
        for (int i = 0; i < tanamans.size(); i++) {
            System.out.println("Tanaman buah ke-" + (i+1));
            System.out.println(tanamans.get(i).toString() + "\n");
        }
    }
    private static int toDay(int month){
        return month * 30;
    }
}
public class UAP {
    public static void main(String[] args) {
        Data.mulai();
        Data.info();
    }
}

