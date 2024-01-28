
class hitungHari {
    private int jumlahLembar;
    private double jumlahHalamanPerhari;
    private int convertJumlahHari;
    public void setJumlahLembar (int i){
        jumlahLembar = i;
    }
    public void setJumlahHalamanPerhari (double d){
        jumlahHalamanPerhari = d;
        jumlahHari();
    }
    public void jumlahHari(){
        double jumlahHari =
                (jumlahLembar*2)/jumlahHalamanPerhari;
        convertJumlahHari = (int) (jumlahHari);
    }
    public void displayMessage(){
        System.out.println("Mahasiswa A ingin menulis pada sebuah buku tulis yang dia miliki.");
        System.out.println("Isi lembar buku tersebut adalah " + jumlahLembar + " lembar.");
        System.out.println("Setiap harinya ia menulis sebanyak " + jumlahHalamanPerhari + " halaman buku.");
        System.out.println("Jumlah hari yang dibutuhkan Mahasiswa A untuk menghabiskan 1 buku adalah "+ convertJumlahHari + " hari.");
    }
}
public class Buku{
    public static void main(String[] args) {
        hitungHari mahasiswaA = new hitungHari();
        mahasiswaA.setJumlahLembar(50);
        mahasiswaA.setJumlahHalamanPerhari(0.5);
        mahasiswaA.displayMessage();
    }
}

