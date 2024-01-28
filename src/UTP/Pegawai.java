package UTP;

public class Pegawai {
    private String nama;
    private String nomorPegawai;

    Pegawai(String nama, String nomorPegawai) {
        setNama(nama);
        setNomorPegawai(nomorPegawai);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPegawai() {
        return nomorPegawai;
    }

    public void setNomorPegawai(String nomorPegawai) {
        this.nomorPegawai = nomorPegawai;
    }

    public void tampilkanInfoPegawai() {
        System.out.println("INFO PEGAWAI DI PERPUSTAKAAN");
        System.out.println("Nama            : " + getNama());
        System.out.println("Nomor Pegawai   : " + getNomorPegawai());
    }

    public void menambahPelanggan(String nama, String nomorPelanggan) {
        if (Perpustakaan.listPelanggan[Perpustakaan.listPelanggan.length - 1] != null)
            return;

        for (int i = 0; i < Perpustakaan.listPelanggan.length; i++) {
            if (Perpustakaan.listPelanggan[i] == null) {
                Perpustakaan.listPelanggan[i] = new Pelanggan(nama, nomorPelanggan);
                System.out.println(Perpustakaan.listPelanggan[i].getNama());
                break;
            }
        }
    }

    public void menambahBuku(String judul, String penulis, int jumlah) {
        if (Perpustakaan.listBuku[Perpustakaan.listBuku.length - 1] != null)
            return;

        for (int i = 0; i < Perpustakaan.listBuku.length; i++) {
            if (Perpustakaan.listBuku[i] == null) {
                Perpustakaan.listBuku[i] = new Buku(judul, penulis, jumlah);
                break;
            }
        }
    }
}