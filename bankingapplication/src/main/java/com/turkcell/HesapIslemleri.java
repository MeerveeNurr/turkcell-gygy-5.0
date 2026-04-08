package com.turkcell;
public class HesapIslemleri implements BankInterface {
    private int bakiye=1500;
    private String sifre="Merve";
    private int hataliGiris=0;
    private boolean hesapBloke=false;
    public boolean isHesapBloke() {
    return hesapBloke;
}
    @Override
    public boolean sifreKontrol(String girilenSifre){
        if(hesapBloke){
            /*System.out.println("Hesabınız bloke edildi.Lütfen bankanızın müşteri hizmetleri ile iletişime geçiniz...");*/
            return false;
        }
        if(this.sifre.equals(girilenSifre)){
            hataliGiris=0;
            return true;
        }else{
            hataliGiris++;
            if(hataliGiris>=3){
                hesapBloke=true;
                System.out.println("Hesabınız bloke edildi.Lütfen bankanızın müşteri hizmetleri ile iletişime geçiniz...");
            }

            return false;
        }
    }

    @Override
    public void bakiyeOgren(){
        System.out.println("Bakiyeniz:"+bakiye);;
    }
    @Override
    public void paraCek(int miktar){
        if(miktar>bakiye){
            System.out.println("Para çekme işlemi gerçekleştirilemedi. Maalesef bakiyeniz yetersiz.");
        } else{
            bakiye-=miktar;
            System.out.println("Para çekme işlemi gerçekleştirildi. Yeni bakiyeniz:"+bakiye);
        }

        }
        @Override
        public void paraYatir(int miktar){
            bakiye+=miktar;
            System.out.println("Para yatırma işlemi gerçekleştirildi.Yeni bakiyeniz:"+bakiye);
        }
        @Override
        public void kartIade(){
            System.out.println("Kartınız iade edildi. Tekrar bekler,iyi günler dileriz...");
        }

    } 
