package PraktikumPBO6;

public class Manusia {
    private String nama;
    private boolean jenisKelamin;
    private String nik;
    private boolean menikah;

    public Manusia(){
        nama = null;
        jenisKelamin = true;
        nik = null;
        menikah = true;
    }
    public Manusia(String nama, boolean jenisKelamin, String nik, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.menikah = menikah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String isJenisKelamin() {
        return jenisKelamin ? "Laki laki" : "Perempuan";

    }

    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public boolean isMenikah() {
        return menikah;
    }

    public void setMenikah(boolean menikah) {
        this.menikah = menikah;
    }

    public double getTunjangan() {
        if (menikah) {
            return jenisKelamin ? 25.0 : 20.0;
        } else {
            return 15.0;
        }
    }
    public double getPendapatan() {
        return getTunjangan();
    }

    @Override
    public String toString() {
        return "Nama=" + nama + " " +
                ", Jenis kelamin=" + isJenisKelamin() + " " +
                ", NIK=" + nik + " " +
                ", Pendapatan=" + getPendapatan()  ;
    }

}

