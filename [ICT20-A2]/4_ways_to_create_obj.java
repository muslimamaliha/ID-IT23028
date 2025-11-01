import java.io.*;

class Pizza implements Cloneable, Serializable {

    void showFood() {
        System.out.println("My favourite food is Pizza!");
    }

    public static void main(String[] args) {
        try {
            // 1. Using new keyword
            Pizza p1 = new Pizza();
            p1.showFood();

            // 2. Using Class.forName()
            Pizza p2 = (Pizza) Class.forName("Pizza").getDeclaredConstructor().newInstance();
            p2.showFood();

            // 3. Using clone()
            Pizza p3 = (Pizza) p1.clone();
            p3.showFood();

            // 4. Using Deserialization
            // write object to file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pizza.txt"));
            out.writeObject(p1);
            out.close();

            // read object from file
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("pizza.txt"));
            Pizza p4 = (Pizza) in.readObject();
            in.close();

            p4.showFood();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
