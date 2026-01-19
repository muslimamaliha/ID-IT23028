import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {

        try {
            // 1. Connect
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "itbatch20"
            );

            // 2. SQL
            String sql = "INSERT INTO student(name, age) VALUES (?, ?)";

            // 3. Prepare
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "Rahim");
            pst.setInt(2, 22);

            // 4. Execute
            pst.executeUpdate();

            // 5. Close
            con.close();

            System.out.println("Data Inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
