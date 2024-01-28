package PraktikumPBO6;

import java.time.LocalDate;

public class Pekerja extends Manusia{
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jenisKelamin, String nik, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }
    public Pekerja(){
        super();
        gaji = 1000000;
        tahunMasuk = null;
        jumlahAnak = 0;
    }
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public double getGaji() {
        return gaji;
    }

    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus(){
        int lamaBekerja = LocalDate.now().getYear() - getTahunMasuk().getYear();
        if (lamaBekerja <= 10) return 0.05*gaji;
        else if (lamaBekerja >= 11 && lamaBekerja <= 15) return 0.10*gaji;
        else return 0.15*gaji;
    }

    public double getTunjangan(){
        if (jumlahAnak >= 1) return 20*jumlahAnak;
        else return 0;
    }

    public double getPendapatan(){
        return super.getTunjangan()+ gaji + getBonus() + getTunjangan();
    }

    @Override
    public String toString() {
        return  super.toString()+ " "+ ", Gaji=" + gaji + " " +
                ", Tahun masuk=" + tahunMasuk + " " +
                ", Jumlah anak=" + jumlahAnak ;
    }
}
