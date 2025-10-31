
package classandobject;
public class Main{
    public static void main(String[] args){
        Car mycar = new Car();//object creation
        mycar.color = "Black";
        mycar.speed = 80;

        mycar.drive();
        System.out.println("Car Color: "+mycar.color);
        System.out.println("Car speed: "+mycar.speed);

    }
}
