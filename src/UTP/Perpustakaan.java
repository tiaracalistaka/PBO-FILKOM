package UTP;

public class Perpustakaan {
    public static Buku[] listBuku = new Buku[100];
    public Pegawai pegawaiPerpus;
    public static Pelanggan[] listPelanggan = new Pelanggan[20];

    Perpustakaan(Pegawai pegawai)
    {
        pegawaiPerpus = pegawai;
    }

    public void pinjam(String namaPelanggan, String judulBuku)
    {
        Buku buku = cariBuku(judulBuku);
        if (buku == null)
        {
            System.out.println("Buku sudah tidak ada!");
            return;
        }

        for (int i = 0; i < listPelanggan.length; i++) {
            if (listPelanggan[i] != null && listPelanggan[i].getNama().equals(namaPelanggan))
            {
                listPelanggan[i].tambahBuku(buku);
                for (int j = 0; j < listBuku.length; j++) {
                    if (listBuku[j] == buku)
                    {
                        listBuku[j].setJumlah(listBuku[j].getJumlah()-1);
                    }
                    if (listBuku[i+1] == null) break;
                }
            }
            if (listPelanggan[i+1] == null) break;
        }
    }


    public Buku cariBuku(String judulBuku)
    {
        for (int i = 0; i < listBuku.length; i++) {
            if (listBuku[i].getJudul().equals(judulBuku))
            {
                return listBuku[i];
            }
            if (listBuku[i+1] == null) break;
        }
        return null;
    }

    public void tampilkanInfoPerpustakaan()
    {
        for (int i = 0; i < listPelanggan.length; i++) {
            listPelanggan[i].tampilkanInfoPelanggan();
            System.out.println();
            if (listPelanggan[i+1] == null) break;
        }
    }

}