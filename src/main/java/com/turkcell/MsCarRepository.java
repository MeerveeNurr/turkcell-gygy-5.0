package com.turkcell;

public class MsCarRepository implements CarRepository 
{
    public void add(Car car){ //imza 

        System.out.println("Araba nesnesi MsSQL'e eklendi"); //gövde 
    }

}
