package PraktikumPBO7;

public class KueJadi extends Kue {
    private double jumlah;

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public KueJadi(String nama, double harga, double jumlah) {
        setNama(nama);
        setHarga(harga);
        this.jumlah = jumlah;
    }

    @Override
    public double hitungHarga() {
        return getHarga() * jumlah * 2;
    }
}
