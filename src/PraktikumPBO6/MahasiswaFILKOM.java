package PraktikumPBO6;

public class MahasiswaFILKOM extends Manusia{
    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String nama, boolean jenisKelamin, String nik, boolean menikah, String nim, double ipk) {
        super(nama, jenisKelamin, nik, menikah);
        this.ipk = ipk;
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public String getStatus(){
        if (nim.substring(6,7).equals("2")) return "Teknik Informatika, 20" + nim.substring(0,2);
        else if (nim.substring(6,7).equals("3")) return "Teknik Komputer, 20" + nim.substring(0,2);
        else if (nim.substring(6,7).equals("4")) return "Sistem Informasi, 20" + nim.substring(0,2);
        else if (nim.substring(6,7).equals("6")) return "Pendidikan Teknologi Informasi, 20" + nim.substring(0,2);
        else return "Teknologi Informasi, 20" + nim.substring(0,2);
    }

    public double getBeasiswa(){
        if(ipk>=3.0 && ipk<=3.5) return 50.0;
        else if (ipk>3.5 && ipk<=4.0) return 75.0;
        else return 0;
    }

    public double getPendapatan(){
        return super.getTunjangan()+getBeasiswa();
    }

    @Override
    public String toString() {
        return   super.toString()  + " " + ", NIM=" + nim + " " +
                ", IPK=" + ipk + " " +
                ", Status=" + getStatus();
    }
}
