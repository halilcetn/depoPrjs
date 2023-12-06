package depo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunnerClass {
    public static void main(String[] args) {



        baslatMenusu();






    }

    DepoServisi depoServisi = new DepoServisi();

    public static void baslatMenusu(){

        int secim = -1;
        Scanner input = new Scanner(System.in);
        DepoServisi depoServisi = new DepoServisi();
        Urun urun = new Urun();
        do {

            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("                  QA03 Firması Depo Uygulamasina Hosgeldiniz                  ");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Bir islem seciniz: \n1-Urun Tanimlama\n2-Urun listeleme\n3-Urun Girisi" +
                    "\n4-Urunu Rafa Yerlestirme\n5-Depodan Urun Cikisi\n6-Cikis yapmak için 0 tusuna basiniz");

            try {


                secim = input.nextInt();
            } catch (InputMismatchException e){
                System.err.println("Lutfen menu icin gecerli bir secim yapınız ");
                input.next();
                continue;
            }

            switch (secim) {
                    case 1:
                        depoServisi.urunTanimlama(urun.getUrunIsmi(), urun.getUretici(), urun.getBirim());
                        break;
                    case 2:
                        depoServisi.urunListele();
                        break;
                    case 3:
                        depoServisi.urunGirisi(depoServisi.idSayac);
                        break;
                    case 4:
                        depoServisi.urunuRafaKoy();
                        break;
                    case 5:
                        depoServisi.urunCikisi(depoServisi.idSayac);
                        break;
                    case 0:
                        System.out.println("Programdan çıkılıyor...");
                        break;
                    default:
                        System.out.println("Geçersiz işlem");
                        break;
                }
        }while (secim != 0);
    }

}