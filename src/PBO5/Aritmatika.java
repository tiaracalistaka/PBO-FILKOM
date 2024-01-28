package PBO5;

public class Aritmatika {
    public static void hitungPenjumlahan(int a,int b){
        int nilai = a+b;
        System.out.println("nilai penjumlahan adalah : "+nilai);
    }
    public static void hitungPerkalian(int a, int b){
        int nilai = a*b;
        System.out.println("nilai perkalian adalah : "+nilai);
    }
    public static void hitungPengurangan(int a, int b){
        int nilai = a-b;
        System.out.println("nilai pengurangan adalah : "+nilai);
    }
    public void hitungPembagian(String nil, String nil2) {
        double a = Double.parseDouble(nil);
        double b = Double.parseDouble(nil2);
        double nilai = a / b;
        System.out.println("nilai pembagian adalah : "+nilai);
    }
}