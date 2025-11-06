package com;

class Car1 {
    private String color = "Black";
    private int speed = 120;

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
}

public class MainGetter {
    public static void main(String[] args) {
        Car1 car = new Car1();
        String c = car.getColor();
        int s = car.getSpeed();
        System.out.println("Color : "+c+", Speed: "+s);
    }
}
