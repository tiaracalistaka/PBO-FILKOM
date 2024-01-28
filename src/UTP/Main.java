package UTP;

public class Main {
    public static void main(String[] args) {
        Pegawai pegawaiPerpus = new Pegawai("Tiara", "225150201111031");
        Perpustakaan perpus = new Perpustakaan(pegawaiPerpus);

        pegawaiPerpus.menambahPelanggan("Hayasaka", "99001110009");
        pegawaiPerpus.menambahPelanggan("Miyuki", "99001100008");
        pegawaiPerpus.menambahPelanggan("Kei", "990011110077");

        pegawaiPerpus.menambahBuku("Heavens", "Tiancan", 3);
        pegawaiPerpus.menambahBuku("Kaguya-sama", "Akasaka", 3);
        pegawaiPerpus.menambahBuku("Solo Leveling", "Chugong", 1);

        perpus.pinjam("Hayasaka", "Overlord");
        perpus.pinjam("Miyuki", "Solo Leveling");
        perpus.pinjam("Kei", "Solo Leveling");
        perpus.pinjam("Hayasaka", "Kaguya-sama");

        pegawaiPerpus.menambahBuku("Overlord", "Maruyama", 3);
        pegawaiPerpus.menambahBuku("Kaguya-sama", "Akasaka", 3);
        pegawaiPerpus.menambahBuku("Solo Leveling", "Chugong", 1);

        perpus.pinjam("Kei", "Heavens");
        perpus.pinjam("Miyuki", "Solo Leveling");
        perpus.pinjam("Kei", "Kaguya-sama");

        pegawaiPerpus.menambahPelanggan("Shinomiya", "2");
        pegawaiPerpus.menambahPelanggan("Miyuki", "1");

        perpus.pinjam("Shinomiya", "Solo Leveling");
        perpus.pinjam("Shirogane", "Kaguya-sama");
        pegawaiPerpus.tampilkanInfoPegawai();
        perpus.tampilkanInfoPerpustakaan();


    }
}
