package com;

class Car2 {
    private String color;
    private int speed;

    public Car2(String color, int speed) {
        this.color = color;
        this.speed = speed;

    }

    public void show(){
        System.out.println("Color: "+color+", Speed: "+speed);
    }
}


public class MainConstructor {
    public static void main(String[] args){
        Car2 c = new Car2("Blue",110);
        c.show();
    }
}
