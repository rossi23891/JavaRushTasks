package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type,int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Car() {

    }

    /*public static Car create(int type, int numberOfPassengers){
        switch (type){
            case 0: return new Truck(numberOfPassengers);
            case 1: return new Sedan(numberOfPassengers);
            case 2: return new Cabriolet(numberOfPassengers);
            default: return null;
        }
    }*/
     public boolean isSummer(Date date , Date summerStart, Date summerEnd){
         return (date.after(summerStart) && date.before(summerEnd));
     }

     public double getWinterConsumption(int length){
         return length * winterFuelConsumption + winterWarmingUp;
     }

    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0){
            throw new Exception();
        }
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (isSummer(date,SummerStart,SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if(canPassengersBeTransferred()){
            return numberOfPassengers;
        }else{
            return 0;
        }
    }

     private boolean canPassengersBeTransferred(){
        return (isDriverAvailable()&& fuel>0);
     }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    int MAX_TRUCK_SPEED = 80;
    int MAX_SEDAN_SPEED = 120;
    int MAX_CABRIOLET_SPEED = 90;

    public abstract int getMaxSpeed();
}