package depo;

public class Urun {

    // pojo class
    //1-) burada oncelikle urunun tanimlamasi  yapilir.
    //     id
    //     urunIsmi
    //     uretici
    //     miktar
    //     birim ve
    //     raf

    private String urunIsmi;
    private String uretici;
    private int miktar;
    private String birim;
    private String rafNumarasi;



    public Urun(String urunIsmi, String uretici, String birim) {
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
    }

    public Urun(String urunIsmi, String uretici, int miktar, String birim, String rafNumarasi) {
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.rafNumarasi = rafNumarasi;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", rafNumarasi='" + rafNumarasi + '\'' +
                '}';
    }

    public String getRafNumarasi() {
        return rafNumarasi;
    }

    public void setRafNumarasi(String rafNumarasi) {
        this.rafNumarasi = rafNumarasi;
    }



    public Urun(){

    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }



    public void setMiktar(int miktar) {
        if (miktar < 0){
            System.out.println("Miktar negatif olamaz!");
        }else {
            this.miktar = miktar;
        }
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public String getBirim() {
        return birim;
    }



}
