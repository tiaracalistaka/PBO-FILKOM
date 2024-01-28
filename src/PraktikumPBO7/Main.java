package PraktikumPBO7;

public class Main {
    public static void main(String[] args) {
        Kue[] kueArray = new Kue[20];
        kueArray[0] = new KuePesanan("Kue Lapis", 10000, 0.5);
        kueArray[1] = new KueJadi("Bolu Coklat", 15000, 10);
        kueArray[2] = new KuePesanan("Kue Sus", 12000, 0.4);
        kueArray[3] = new KueJadi("Roti Tawar", 5000, 20);
        kueArray[4] = new KuePesanan("Kue Tart", 25000, 0.8);
        kueArray[5] = new KueJadi("Donat", 2000, 30);
        kueArray[6] = new KuePesanan("Brownies", 20000, 0.6);
        kueArray[7] = new KueJadi("Kue Pandan", 10000, 15);
        kueArray[8] = new KuePesanan("Lemper Ayam", 8000, 0.3);
        kueArray[9] = new KueJadi("Kue Lumpur", 12000, 12);
        kueArray[10] = new KuePesanan("Martabak Manis", 25000, 1);
        kueArray[11] = new KueJadi("Chiffon Cake", 18000, 8);
        kueArray[12] = new KuePesanan("Puding", 10000, 0.5);
        kueArray[13] = new KueJadi("Kue Kering", 8000, 50);
        kueArray[14] = new KuePesanan("Nastar", 15000, 0.7);
        kueArray[15] = new KueJadi("Kue Keju", 10000, 20);
        kueArray[16] = new KuePesanan("Kue Mangkok", 12000, 0.5);
        kueArray[17] = new KueJadi("Bika Ambon", 30000, 5);
        kueArray[18] = new KuePesanan("Kue Coklat", 10000, 0.5);
        kueArray[19] = new KueJadi("Strawberry Cheese", 30000, 5);

        // Tampilkan semua kue dan jenisnya
        System.out.println("Daftar Kue:");
        for (int i = 0; i < kueArray.length; i++) {
            System.out.println((i + 1) + ". " + kueArray[i].getNama() + " (" + kueArray[i].getClass().getSimpleName() + ")");
        }


// Hitung total harga dari semua jenis kue
        double totalHarga = 0;
        for (int i = 0; i < kueArray.length; i++) {
            totalHarga += kueArray[i].hitungHarga();
        }
        System.out.println("Total harga dari semua jenis kue adalah " + totalHarga);

// Hitung total harga dan total berat dari KuePesanan
        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        for (int i = 0; i < kueArray.length; i++) {
            if (kueArray[i] instanceof KuePesanan) {
                totalHargaPesanan += kueArray[i].hitungHarga();
                totalBeratPesanan += ((KuePesanan) kueArray[i]).getBerat();
            }
        }
        System.out.println("Total harga dari KuePesanan adalah " + totalHargaPesanan);
        System.out.println("Total berat dari KuePesanan adalah " + totalBeratPesanan);


/// Hitung total harga dan total jumlah dari KueJadi
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;
        for (int i = 0; i < kueArray.length; i++) {
            if (kueArray[i] instanceof KueJadi) {
                totalHargaJadi += kueArray[i].hitungHarga();
                totalJumlahJadi += ((KueJadi) kueArray[i]).getJumlah();
            }
        }
        System.out.println("Total harga dari KueJadi adalah " + totalHargaJadi);
        System.out.println("Total jumlah dari KueJadi adalah " + totalJumlahJadi);

        // Tampilkan informasi kue dengan harga terbesar
        Kue kueTermahal = kueArray[0];
        for (int i = 1; i < kueArray.length; i++) {
            if (kueArray[i].hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = kueArray[i];
            }
        }
        System.out.println("Kue dengan harga terbesar adalah " + kueTermahal.getNama() + " dengan harga " + kueTermahal.hitungHarga());
    }
}