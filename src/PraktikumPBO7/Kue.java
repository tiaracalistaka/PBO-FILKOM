package PraktikumPBO7;

public abstract class Kue {
    private String nama;
    private double harga;
    public abstract double hitungHarga();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return  "Nama='" + nama + " " +
                ", Harga=" + harga ;
    }
}
