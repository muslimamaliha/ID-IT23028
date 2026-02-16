import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String deptName = request.getParameter("deptName");
        String numStudentsStr = request.getParameter("numStudents");
        String action = request.getParameter("action");

        int numStudents = 0;
        if (numStudentsStr != null && !numStudentsStr.isEmpty()) {
            numStudents = Integer.parseInt(numStudentsStr);
        }

        ServiceClass service = new ServiceClass();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Current date & time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDate = now.format(dtf);

        out.println("<html><head><style>");
        out.println("table { border-collapse: collapse; width: 50%; }");
        out.println("th, td { border: 1px solid #333; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style></head><body>");

        out.println("<h2>Action: " + action + "</h2>");
        out.println("<p>Current Date & Time: " + formattedDate + "</p>");

        switch (action) {
            case "Insert":
                if (service.insertDB(deptName, numStudents)) {
                    out.println("<p>Inserted successfully.</p>");
                } else {
                    out.println("<p>Insertion failed.</p>");
                }
                break;

            case "View":
                List<String> depts = service.viewDB();
                if (depts.isEmpty()) {
                    out.println("<p>No departments found.</p>");
                } else {
                    out.println("<table>");
                    out.println("<tr><th>Department Name</th><th>Number of Students</th></tr>");
                    for (String dept : depts) {
                        String[] parts = dept.split(", Students: ");
                        String name = parts[0].replace("Dept: ", "");
                        String count = parts.length > 1 ? parts[1] : "0";
                        out.println("<tr><td>" + name + "</td><td>" + count + "</td></tr>");
                    }
                    out.println("</table>");
                }
                break;

            case "Update":
                if (service.updateDB(deptName, numStudents)) {
                    out.println("<p>Updated successfully.</p>");
                } else {
                    out.println("<p>Update failed. Department not found?</p>");
                }
                break;

            case "Delete":
                if (service.deleteDB(deptName)) {
                    out.println("<p>Deleted successfully.</p>");
                } else {
                    out.println("<p>Delete failed. Department not found?</p>");
                }
                break;

            default:
                out.println("<p>Unknown action.</p>");
        }

        out.println("</body></html>");
    }
}
