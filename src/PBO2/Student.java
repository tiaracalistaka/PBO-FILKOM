package PBO2;

public class Student {
        private String name;
        private String address;
        private int age;
        private double mathGrade;
        private double englishGrade;
        private double scienceGrade;
        private double average; // average
        private boolean statusAkhir;
        public static int hitung = 0;

        public Student() {
                name = "";
                address = "";
                age = 0;
                mathGrade = 0;
                englishGrade = 0;
                scienceGrade = 0;

        }

        public Student(String n, String a, int ag, double math, double english, double science) {
                name = n;
                address = a;
                age = ag;
                mathGrade = math;
                englishGrade = english;
                scienceGrade = science;
                hitung++;
        }

        public void setName(String n) {
                name = n;
        }

        public void setAddress(String a) {
                address = a;
        }

        public void setAge(int ag) {
                age = ag;
        }

        public void setMath(int math) {
                mathGrade = math;
        }

        public void setEnglish(int english) {
                englishGrade = english;
        }

        public void setScience(int science) {
                scienceGrade = science;
        }

        private double getAverage() {
                double result = 0;
                result = (mathGrade + scienceGrade + englishGrade) / 3;
                average = result;
                return average;
        }

        private boolean getStatusAkhir() {
                if (getAverage() >= 61) {
                        statusAkhir = true;
                } else {
                        statusAkhir = false;
                }
                return statusAkhir;
        }

        public void displayMessage() {
                System.out.println("Siswa dengan nama " + name);
                System.out.println("beralamat di " + address);
                System.out.println("berumur " + age);
                if(getStatusAkhir() == true) {
                        System.out.println("LULUS");
                } else {
                        System.out.println("REMED");
                }
        }

        public static void jumlahObjek(){
                System.out.println("Total objek yang dibuat : " +hitung);
        }
}
