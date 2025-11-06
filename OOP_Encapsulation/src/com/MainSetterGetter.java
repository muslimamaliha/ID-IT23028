package com;

class Car3 {
    private String color;
    private int speed;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}

public class MainSetterGetter {
    public static void main(String[] args) {
        Car3 c = new Car3();
        c.setColor("Grey");
        c.setSpeed(150);

        System.out.println("Color: "+c.getColor()+", Speed: "+c.getSpeed());
    }
}
