package com.turkcell;
public interface BankInterface {
    public void paraYatir(int miktar);
    public void paraCek(int miktar);
    public void bakiyeOgren();
    public void kartIade();
    public boolean sifreKontrol(String sifre);

}