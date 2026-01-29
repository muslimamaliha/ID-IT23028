
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class QuizServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String studentId = req.getParameter("studentId");
        int score = 0;

        if("4".equals(req.getParameter("q1"))) score++;
        if("8".equals(req.getParameter("q2"))) score++;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quizdb","root","itbatch20");

            PreparedStatement ps =
                con.prepareStatement("INSERT INTO score(student_id,score) VALUES (?,?)");
            ps.setString(1, studentId);
            ps.setInt(2, score);
            ps.executeUpdate();
            con.close();
        } catch(Exception e){ e.printStackTrace(); }

        PrintWriter out = res.getWriter();
        out.println("<h2>আপনার স্কোর: "+score+"/2</h2>");
    }
}
