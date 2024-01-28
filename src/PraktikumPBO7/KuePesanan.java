package PraktikumPBO7;

public class KuePesanan extends Kue{
    private double berat;
    public KuePesanan(String nama, double harga, double berat) {
        setNama(nama);
        setHarga(harga);
        this.berat = berat;
    }

    @Override
    public double hitungHarga() {
        return getHarga() * berat;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }
}
