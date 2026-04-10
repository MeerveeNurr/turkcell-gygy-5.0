package com.turkcell;

public class Interfaces {
 public static void main(String[] args) {
    CarRepository carRepository = new MsCarRepository(); //Sol taraf->bana CarRepository kurallarına uyan somut bir class ver.
    carRepository.add(new Car(true,"BMW"));
    carRepository.add(new Car(false,"Mercedes"));
    carRepository.add(new Car(true,"Ford"));
    
 }
}
