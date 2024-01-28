package PBO7;

import java.time.LocalDate;

public abstract class Employee {
    private String name;
    private String noKTP;
    private LocalDate tanggalLahir;
    private double hargaBarang;
    private double wagePerItem;
    private int quantity;
    public Employee(String name, String noKTP, double wagePerItem, int quantity,LocalDate tanggalLahir){
        this.name = name;
        this.noKTP = noKTP;
        this.tanggalLahir = tanggalLahir;
        setWagePerItem(wagePerItem);
        setQuantity(quantity);
   }
    public void setWagePerItem(double wagePerItem){
        this.wagePerItem = wagePerItem;
    }
    public double getWagePerItem(){
        return wagePerItem;
    }
    public void setQuantity(int quantity){
      this.quantity = quantity;
    }
        public int getQuantity(){
            return quantity;
        }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public double bonus(){
        double bonus = 0.0;
        LocalDate today = LocalDate.now();
        if (today.getMonth() == tanggalLahir.getMonth()) {
            bonus = 100000.0;
        }
        return bonus;
    }


    public String getName(){
        return name;
    }
    public String getNoKTP(){
        return noKTP;
    }
    public String toString(){
        return String.format(" "+getName()+"\nNo. KTP:"+getNoKTP()+"\nwage per item: "+getWagePerItem()+"\nquantity produced: "+getQuantity());
    }
    public abstract double earnings();
}
