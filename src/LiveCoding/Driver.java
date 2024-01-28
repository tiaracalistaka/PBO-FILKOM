package LiveCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Manusia {
    protected String nama;
    protected double koordinatX;
    protected double koordinatY;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        if (nama == null) {
            return "";
        }
        return this.nama;
    }

    public double getKoordinatX() {
        return koordinatX;
    }

    public double getKoordinatY() {
        return koordinatY;
    }
}

class Pengirim extends Manusia {
    public Pengirim(String nama, double xPengirim, double yPengirim) {
        this.nama = nama;
        this.koordinatX = xPengirim;
        this.koordinatY = yPengirim;
    }

    public Pengirim() {
    }
}

class Penerima extends Manusia {
    public Penerima(String nama, double xPenerima, double yPenerima) {
        this.nama = nama;
        this.koordinatX = xPenerima;
        this.koordinatY = yPenerima;
    }

    public Penerima() {
    }
}

class Kurir extends Manusia {
    private String nomorPolisi;

    public Kurir(String nomorPolisi, double xKurir, double yKurir) {
        this.nomorPolisi = nomorPolisi;
        this.koordinatX = xKurir;
        this.koordinatY = yKurir;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public double getXKurir() {
        return koordinatX;
    }

    public double getYKurir() {
        return koordinatY;
    }

    public double hitungJarak(Manusia manusia1, Manusia manusia2) {
        double x1 = manusia1.getKoordinatX();
        double y1 = manusia1.getKoordinatY();
        double x2 = manusia2.getKoordinatX();
        double y2 = manusia2.getKoordinatY();

        double xDistance = x2 - x1;
        double yDistance = y2 - y1;
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }
}

abstract class JenisKiriman {
    private int hargaPerKm;

    public JenisKiriman(int hargaPerKm) {
        this.hargaPerKm = hargaPerKm;
    }

    public int getHargaPerKm() {
        return hargaPerKm;
    }

    public abstract double hitungBiaya(double jarak);
}

class KirimanInstan extends JenisKiriman {
    public KirimanInstan() {
        super(2000);
    }

    @Override
    public double hitungBiaya(double jarak) {
        return getHargaPerKm() * jarak;
    }
}

class SameDay extends JenisKiriman {
    public SameDay() {
        super(1000);
    }

    @Override
    public double hitungBiaya(double jarak) {
        return getHargaPerKm() * jarak;
    }
}

interface BandingkanKurir {
    Kurir cariKurirTerdekat(List<Kurir> daftarKurir, Pengirim pengirim);
}

class KurirTerdekat implements BandingkanKurir {
    @Override
    public Kurir cariKurirTerdekat(List<Kurir> daftarKurir, Pengirim pengirim) {
        Kurir kurirTerdekat = null;
        double jarakTerdekat = Double.MAX_VALUE;

        for (Kurir kurir : daftarKurir) {
            double jarak = kurir.hitungJarak(pengirim, kurir);
            if (jarak < jarakTerdekat) {
                jarakTerdekat = jarak;
                kurirTerdekat = kurir;
            }
        }
        return kurirTerdekat;
    }
}

public class Driver {
    private static Scanner in = new Scanner(System.in);
    private static HashMap<String, Pengirim> mapPengirim = new HashMap<>();
    private static HashMap<String, KirimanInstan> mapInstant = new HashMap<>();
    private static HashMap<String, SameDay> mapSameDay = new HashMap<>();
    private static HashMap<String, List<Kurir>> listKurir = new HashMap<>();

    public static void main(String[] args) {
        while (in.hasNextLine()) {
            try {
                String input = in.nextLine();
                if (input.contains("TAMBAH PENGIRIM")) {
                    tambahPengirim(input);
                } else if (input.contains("TAMBAH KURIR")) {
                    tambahKurir(input);
                } else if (input.contains("KIRIM INSTANT")) {
                    kirimInstant(input);
                } else if (input.contains("KIRIM SAMEDAY")) {
                    kirimSameDay(input);
                } else if (input.contains("CETAK")) {
                    printPengirim(input);
                } else {
                    System.out.println("INVALID_FORMAT");
                    break;
                }
            } catch (Exception e) {
                System.out.println("INVALID_FORMAT");
                break;
            }
        }
        in.close();
    }

    private static void tambahPengirim(String input) {
        String[] data = input.split(" ");
        String namaPengirim = data[2];
        double xPengirim = Double.parseDouble(data[3]);
        double yPengirim = Double.parseDouble(data[4]);

        if (mapPengirim.containsKey(namaPengirim)) {
            System.out.println("Pengirim " + namaPengirim + " sudah ada");
        } else {
            Pengirim pengirim = new Pengirim(namaPengirim, xPengirim, yPengirim);
            mapPengirim.put(namaPengirim, pengirim);
            System.out.println("Pengirim " + namaPengirim + " berhasil ditambahkan");
        }
    }

    private static void tambahKurir(String input) {
        String[] data = input.split(" ");
        String namaKurir = data[2];
        String nomorPolisi = data[3];
        double xKurir = Double.parseDouble(data[4]);
        double yKurir = Double.parseDouble(data[5]);

        if (listKurir.containsKey(namaKurir)) {
            List<Kurir> kurirList = listKurir.get(namaKurir);
            for (Kurir kurir : kurirList) {
                if (kurir.getNomorPolisi().equals(nomorPolisi)) {
                    System.out.println("Kurir " + namaKurir + " dengan nomor polisi " + nomorPolisi + " sudah ada");
                    return;
                }
            }
            Kurir kurir = new Kurir(nomorPolisi, xKurir, yKurir);
            kurirList.add(kurir);
        } else {
            List<Kurir> kurirList = new ArrayList<>();
            Kurir kurir = new Kurir(nomorPolisi, xKurir, yKurir);
            kurirList.add(kurir);
            listKurir.put(namaKurir, kurirList);
        }
        System.out.println("Kurir " + namaKurir + " berhasil ditambahkan");
    }

    private static void kirimInstant(String input) {
        String[] data = input.split(" ");
        String namaPengirim = data[2];
        double xPenerima = Double.parseDouble(data[3]);
        double yPenerima = Double.parseDouble(data[4]);

        Pengirim pengirim = mapPengirim.get(namaPengirim);
        if (pengirim == null) {
            System.out.println("Pengirim " + namaPengirim + " tidak ditemukan");
            return;
        }

        JenisKiriman jenisKiriman = mapInstant.get("INSTANT");
        if (jenisKiriman == null) {
            jenisKiriman = new KirimanInstan();
            mapInstant.put("INSTANT", (KirimanInstan) jenisKiriman);
        }

        KurirTerdekat kurirTerdekat = new KurirTerdekat();
        Kurir kurir = kurirTerdekat.cariKurirTerdekat(listKurir.get("INSTANT"), pengirim);
        if (kurir == null) {
            System.out.println("Tidak ada kurir yang tersedia");
            return;
        }

        Penerima penerima = new Penerima("Penerima", xPenerima, yPenerima);
        double jarak = kurir.hitungJarak(pengirim, penerima);
        double biaya = jenisKiriman.hitungBiaya(jarak);

        System.out.println("Jarak " + pengirim.getNama() + " ke tujuan adalah " + jarak + " km");
        System.out.println("Kurir terdekat adalah " + jarak + " km yaitu " + kurir.getNama());
        System.out.println("Kurir adalah " + kurir.getNama() + " dengan nomor polisi " + kurir.getNomorPolisi());
        System.out.println("Biaya kirim INSTANT untuk " + pengirim.getNama() + " adalah " + biaya);
    }

    private static void kirimSameDay(String input) {
        String[] data = input.split(" ");
        String namaPengirim = data[2];
        double xPenerima = Double.parseDouble(data[3]);
        double yPenerima = Double.parseDouble(data[4]);

        Pengirim pengirim = mapPengirim.get(namaPengirim);
        if (pengirim == null) {
            System.out.println("Pengirim " + namaPengirim + " tidak ditemukan");
            return;
        }

        JenisKiriman jenisKiriman = mapSameDay.get("SAMEDAY");
        if (jenisKiriman == null) {
            jenisKiriman = new SameDay();
            mapSameDay.put("SAMEDAY", (SameDay) jenisKiriman);
        }

        KurirTerdekat kurirTerdekat = new KurirTerdekat();
        Kurir kurir = kurirTerdekat.cariKurirTerdekat(listKurir.get("SAMEDAY"), pengirim);
        if (kurir == null) {
            System.out.println("Tidak ada kurir yang tersedia");
            return;
        }

        Penerima penerima = new Penerima("Penerima", xPenerima, yPenerima);
        double jarak = kurir.hitungJarak(pengirim, penerima);
        double biaya = jenisKiriman.hitungBiaya(jarak);

        System.out.println("Jarak " + pengirim.getNama() + " ke tujuan adalah " + jarak + " km");
        System.out.println("Kurir terdekat adalah " + jarak + " km yaitu " + kurir.getNama());
        System.out.println("Kurir adalah " + kurir.getNama() + " dengan nomor polisi " + kurir.getNomorPolisi());
        System.out.println("Biaya kirim SAMEDAY untuk " + pengirim.getNama() + " adalah " + biaya);
    }

    private static void printPengirim(String input) {
        String[] data = input.split(" ");
        String namaPengirim = data[1];

        Pengirim pengirim = mapPengirim.get(namaPengirim);
        if (pengirim == null) {
            System.out.println("Pengirim " + namaPengirim + " tidak ditemukan");
            return;
        }

        System.out.println("Pengirim: " + pengirim.getNama());
        System.out.println("Koordinat X: " + pengirim.getKoordinatX());
        System.out.println("Koordinat Y: " + pengirim.getKoordinatY());
    }
}
