package PraktikumPBO6;

import java.time.LocalDate;

public class Manager extends Pekerja{
    private String departemen;

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public Manager(String nama, boolean jenisKelamin, String nik, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, jenisKelamin, nik, menikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }
    public double getTunjangan(){
        return 0.10*getGaji();
    }

    public double getPendapatan(){
        return super.getPendapatan() + getTunjangan() ;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Departemen='" + departemen ;
    }
}
