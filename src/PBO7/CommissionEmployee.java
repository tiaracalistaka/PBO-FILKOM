package PBO7;

import java.time.LocalDate;

public class CommissionEmployee extends Employee {
    private double grossSales;//penjualan per minggu
    private double commissionRate;//komisi
    public CommissionEmployee(String name, String noKTP, double wagePerItem, int quantity, LocalDate tanggalLahir, double sales, double rate){
        super(name, noKTP, wagePerItem, quantity, tanggalLahir);
        setGrossSales(sales);
        setCommissionRate(rate);
    }
    public void setGrossSales(double sales){
        grossSales = sales;
    }
    public double getGrossSales(){
        return grossSales;
    }
    public void setCommissionRate(double rate){
        commissionRate = rate;
    }
    public double getCommissionRate(){
        return commissionRate;
    }
    public double earnings(){
        return (getCommissionRate()*getGrossSales()) + bonus() + (getWagePerItem() * getQuantity());
    }
    public String toString(){
        return String.format("Commision employee: "+super.toString()+"\ngross sales: "+getGrossSales()+"\ncommission rate:"+getCommissionRate());
    }
}
