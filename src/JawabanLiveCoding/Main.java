package JawabanLiveCoding;

class Orang{
    String nama;
    double x;
    double y;

    public Orang(String nama, double x, double y) {
        this.nama= nama;
        this.x=x;
        this.y=y;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class Kurir extends Orang {
    String platNomor;
    pengirim CalonPengirim;

    public pengirim getCalonPengirim() {
        return CalonPengirim;
    }

    public void setCalonPengirim(pengirim calonPengirim) {
        CalonPengirim = calonPengirim;
    }

    public Kurir(String nama, String platNomor, double x, double y) {
        super(nama, x, y);
        this.platNomor = platNomor;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

}

class pengirim extends Orang{
    double xTujuan;
    double yTujuan;
    JenisKiriman jk;
    Kurir k;
    pengirim CalonPengirim;

    public pengirim(String nama, double x, double y){
        super(nama,x,y);
    }

    public double getxTujuan() {
        return xTujuan;
    }

    public void setxTujuan(double xTujuan) {
        this.xTujuan = xTujuan;
    }

    public double getyTujuan() {
        return yTujuan;
    }

    public void setyTujuan(double yTujuan) {
        this.yTujuan = yTujuan;
    }

    public JenisKiriman getJk() {
        return jk;
    }

    public void setJk(JenisKiriman jk) {
        this.jk = jk;
    }

    public Kurir getK() {
        return k;
    }

    public void setK(Kurir k) {
        this.k = k;
    }
    public double getJarakKurir() {
        if (k != null) {
            return Util.getJarak(this.getX(), k.getX(), this.getY(), k.getY());
        }
        return 0;
    }

    public double getJarakPengirim() {
        if (CalonPengirim != null) {
            return Util.getJarak(this.getX(), CalonPengirim.getX(), this.getY(), CalonPengirim.getY());
        }
        return 0;
    }

    public int compareTo(Kurir o) {
        double jarakThis = this.getJarakPengirim();
        double jarakO = o.CalonPengirim.getJarakKurir();
        return Double.compare(jarakThis, jarakO);
    }

}

abstract class JenisKiriman{
    public abstract double getHarga();
}

class JenisKirimanInstant extends JenisKiriman{
   @Override
    public double getHarga() {
        return 2000;
    }
}
class JenisKirimanSameDay extends JenisKiriman{
    public double getHarga(){
        return 1000;
    }
}

class Util {
    public static double getJarak (double x1, double x2, double y1, double y2){
        double jarakX = Math.abs(x2 - x1);
        double jarakY = Math.abs(y2 - y1);
        return Math.sqrt(jarakX * jarakX + jarakY * jarakY);
    }
}
    public class Main {
}
