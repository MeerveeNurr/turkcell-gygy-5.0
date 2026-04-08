package com.turkcell;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HesapIslemleri hesapIslemleri = new HesapIslemleri();
    boolean secenek = true;
    boolean girisBasarili = false;

System.out.println("Welcome to the Bank...");

while (!girisBasarili) {
    System.out.println("Lütfen şifrenizi giriniz.");
    String sifre = scanner.next();

    if (hesapIslemleri.sifreKontrol(sifre)) {
        girisBasarili = true;
        System.out.println("Giriş başarılı...");
    } else {
        if (hesapIslemleri.isHesapBloke()) {
            return;
        } else {
            System.out.println("Hatalı şifre girdiniz. Lütfen tekrar deneyiniz...");
        }
    }
}
        while(secenek){
            System.out.println("1-Bakiye Görüntüle");
            System.out.println("2-Para Cek");
            System.out.println("3-Para Yatır");
            System.out.println("4-Kart İade");
            System.out.println("5-Çıkış");
            int secim = scanner.nextInt();
            switch (secim){
                case 1:
                    hesapIslemleri.bakiyeOgren();
                    break;
                case 2:
                    System.out.println("Çekmek istediğiniz miktarı giriniz: ");
                    int cekilecekMiktar = scanner.nextInt();
                    hesapIslemleri.paraCek(cekilecekMiktar);
                    break;
                case 3:
                    System.out.println("Yatırmak istediğiniz miktarı giriniz: ");
                    int yatirilacakMiktar = scanner.nextInt();
                    hesapIslemleri.paraYatir(yatirilacakMiktar);
                    break;
                case 4:
                    hesapIslemleri.kartIade();
                    break;
                case 5:
                    secenek = false;
                    break;
            }
        }
    }
}