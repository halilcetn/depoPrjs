package depo;

import java.util.*;

public class DepoServisi {


    Urun urun = new Urun();
    Scanner input = new Scanner(System.in);
    int idSayac = 2000; // Sayaç başlangıç değeri
    Map<Integer, Urun> urunListesi = urunListesi = new HashMap<>();// key = ınteger= id,   value = Urun

    List<String> rafKontrolListesi = new ArrayList<>();


    // EKLENECEKLER:
    // 1- idSayac ekle, yeni ürünler için
    // 2- ürün tanımlama metodu yaz

    // QA3 Unlu mamülleri fabrikası -> un,        şeker   ,      yağ,         yumurta,      tuz
    // Üretici Firma                   Değirmen   Pancaroviç     Sarıkız      Bilibili      Delibekir
    // İd                              1001       1002           1003         1004          1005
    // Birim                           (çuval)    (çuval)        (teneke)     (koli)        (çuval)


    public void urunTanimlama(String urunIsmi, String uretici, String birim) {
        idSayac++;
        System.out.println("Ürün adını giriniz: ");
        urunIsmi = input.next().toUpperCase();
        System.out.println("Üretici adını giriniz: ");
        uretici = input.next().toUpperCase();
        if (!urunVarmi( urunIsmi, uretici)){
            System.err.println("Giris yapmak istediginiz depoda mevcut. Mevcut olan urune urun giris yapınız");
            urunListele();
            return;
        }
        System.out.println("Birimi giriniz: ");
        birim = input.next().toUpperCase();
        Urun urun1 = new Urun(urunIsmi, uretici, 0, birim, null);     // miktar = 0 ve raf = null başl. değeri
        urunListesi.put(idSayac, urun1);                                            // tanımlanan ürün map'e eklendi
        System.out.println(urun1 + " ürünü eklendi.");
        input.nextLine(); //dumpy

    }

    public void urunListele() {
        System.out.printf("%-10s %-15s %-20s %-10s %-10s %-10s\n", "ID", "ismi", "ureticisi", "miktari", "birimi", "raf");
        System.out.println("----------------------------------------------------------");
        for (Integer w : urunListesi.keySet()) {
            Urun obje = urunListesi.get(w);
            System.out.printf("%-10d %-15s %-20s %-10d %-10s %-10s\n", w, obje.getUrunIsmi(), obje.getUretici(), obje.getMiktar(), // id idsayac tı   sıkıntı oluyordu onu w yaptım
                    obje.getBirim(), (obje.getRafNumarasi() != null ? obje.getRafNumarasi() : "Belirtilmemiş"));
        }
        System.out.println("-----------------------------------------------------------");
    }


    public void urunGirisi(int idSayac) {

        int secim = 0;
        do {
            for (Integer w : urunListesi.keySet()) {
                Urun obje = urunListesi.get(w);
                System.out.println(w + " id'sine ait ürün: " + obje.getUrunIsmi());
            }
            System.out.println("Girmek istediğiniz ürünün id'sini giriniz: ");
            try {
                idSayac = input.nextInt();
                for (Map.Entry<Integer, Urun> entry : urunListesi.entrySet()) { // Map yapısında, entrySet() metodu ile Map.Entry<Integer, Urun> elemanlarına erişebiliriz.
                    if (entry.getKey() == idSayac) { // entry.getKey() ile anahtarı alabiliriz
                        Urun urun = entry.getValue(); // entry.getValue() ile değeri alabiliriz
                        System.out.println("Girmek istediğiniz miktarı yazınız: ");
                        int miktar = input.nextInt();
                        if (miktar > 0) {
                            int yeniMiktar = urun.getMiktar() + miktar;
                            urun.setMiktar(yeniMiktar);
                            System.out.println(miktar + " miktarınca ekleme yapıldı. Son miktar: " + urun.getMiktar() + "'dır.");
                        } else {
                            System.out.println("Ürün miktarı 0 ya da eksi olamaz");
                        }
                        return; // İşlem başarılıysa fonksiyondan çık
                    }
                }
                System.out.println("Üzgünüz, girmiş olduğunuz ID'ye ait bir ürün bulunamadı. Lütfen geçerli bir ID girin.");
            } catch (InputMismatchException e) {
                System.out.println("Hatalı giriş! Lütfen sayısal bir değer girin.");
                input.nextLine();  //Hatalı girişi temizle
            }
            secim++;
        } while (secim != 2);

    }

    public void urunuRafaKoy() {
        urunListele();
        System.out.println("Ürünü yerleştirmek istediğiniz raf numarasını giriniz: ");
        String rafNumarasi = input.next();
        if (rafKontrolListesi.contains(rafNumarasi)) { //Raf kontrolu
            System.out.println("Ürünü eklemek istediginiz raf dolu.Sizi bir ust menuye yonlendiriyorum");
            return;
        } else {
            rafKontrolListesi.add(rafNumarasi);
        }
        System.out.println("Ürün ID'sini giriniz: ");
        int id = input.nextInt();
        Urun urun = urunListesi.get(id);
        if (urun != null) {
            if (urun.getRafNumarasi() == null) { // != di == yaptım
                urun.setRafNumarasi(rafNumarasi); //ürün mevcutsa belirtilen rafa ürünü ekler
                System.out.println("Ürün başarıyla rafa yerleştirildi. Raf Numarası: " + rafNumarasi);
                return;
            } else {
                System.out.println(rafNumarasi + " nolu raf dolu!");
            }
        } else {
            System.out.println("Üzgünüz, girmiş olduğunuz ID'ye ait bir ürün bulunamadı. Lütfen tekrar deneyiniz.");
        }
    }


    public void urunCikisi(int idSayac) {
        try {
            urunListele();
            System.out.println("Çıkarmak istediğiniz ürünün ID'sini giriniz: ");
            int id = input.nextInt();
            Urun urun = urunListesi.get(id);
            if (urun != null) {
                System.out.println("Çıkarmak istediğiniz miktarı yazınız: ");
                int miktar = input.nextInt();
                if (miktar > urun.getMiktar()) {
                    System.out.println("Çıkıs yapmak istediginiz miktar mevcut miktardan buyuk olamaz ");
                } else if (miktar > 0 && miktar <= urun.getMiktar()) {
                    int yeniMiktar = urun.getMiktar() - miktar;
                    urun.setMiktar(yeniMiktar);
                    System.out.println(miktar + " miktarınca çıkarma yapıldı. Son miktar: " + urun.getMiktar() + "'dır.");
                } else if (miktar < 0) {
                    System.out.println("Çıkıs yapılmak istenen miktar negatif olamaz");
                }
            } else {
                System.out.println("Üzgünüz, girmiş olduğunuz ID'ye ait bir ürün bulunamadı. Lütfen geçerli bir ID girin.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lütfen geçerli bir sayı giriniz.");
        }
    }


    private boolean urunVarmi(String urunIsmi, String uretici) {
        for (Integer w : urunListesi.keySet()) {
            Urun obje = urunListesi.get(w);
            if (Objects.equals(urunIsmi, obje.getUrunIsmi()) && Objects.equals(uretici, obje.getUretici())) {
                return false;
            }
        }
        return true;
        }
    }

