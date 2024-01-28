package PBO7;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double weeklySalary; //gaji/minggu
    public SalariedEmployee(String name, String noKTP, double wagePerItem, int quantity, LocalDate tanggalLahir, double salary) {
        super(name, noKTP, wagePerItem, quantity,tanggalLahir);
        setWeeklySalary(salary);
    }
    public void setWeeklySalary(double salary) {
        weeklySalary = salary;
    }
    public double getWeeklySalary() {
        return weeklySalary;
    }
    public double earnings() {
        return getWeeklySalary()+bonus()+(getWagePerItem() * getQuantity());
    }
    public String toString() {
        return String.format("Salaried employee: " +
                super.toString() +
                "\nweekly salary:" + getWeeklySalary());
    }
}