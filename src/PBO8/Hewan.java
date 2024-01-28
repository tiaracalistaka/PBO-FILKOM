package PBO8;

public class Hewan implements MakhlukHidup{
    private String nama;
    private int umur;
    @Override
    public void makan() {
        System.out.println("Makan pakai tangan dan mulut");
    }
    @Override
    public void berjalan() {
        System.out.println("Jalan pakai 4 kaki");
    }
    @Override
    public void bersuara() {
        System.out.println("Suaranya nggak jelas");
    }

    @Override
    public void tampilkanNama() {
        System.out.println("Nama hewan: " + this.nama);
    }
    @Override
    public void tampilkanUmur() {
        System.out.println("Umur hewan: " + this.umur);
    }

    public Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        tampilkanNama();
        tampilkanUmur();
    }

}
