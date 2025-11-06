package com;

class Car {
    private String color;
    private int speed;

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void showCar(){
        System.out.println("Color :"+color+", Speed :"+speed);
    }
}

public class MainSetter {
    public static void main(String[] args) {
        Car c = new Car();
        c.setColor("Red");
        c.setSpeed(100);
        c.showCar();
    }
}
