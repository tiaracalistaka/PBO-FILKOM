package PBO7;

import java.time.LocalDate;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;//gaji pokok tiap minggu
    public BasePlusCommissionEmployee(String name, String noKTP, double wagePerItem, int quantity, LocalDate tanggalLahir, double sales, double rate, double salary) {
        super(name, noKTP, wagePerItem, quantity, tanggalLahir, sales, rate);
        setBaseSalary(salary);
    }
    public void setBaseSalary(double salary) {
        baseSalary = salary;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public double earnings() {
        return getBaseSalary() + super.earnings() + bonus() + (getWagePerItem() * getQuantity());
    }
    public String toString() {
        return String.format("Base-Salaried " +
                super.toString() + "\nbase salary " + getBaseSalary());
    }
}
