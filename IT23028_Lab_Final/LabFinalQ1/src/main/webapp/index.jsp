<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department Management</title>
<style>
    table { border-collapse: collapse; width: 50%; margin-top: 20px; }
    th, td { border: 1px solid #333; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
</style>
</head>
<body>

<h2>Department Management</h2>

<form action="TestServlet" method="get">
    <label>Department Name:</label>
    <input type="text" name="deptName" required /><br><br>

    <label>Number of Students:</label>
    <input type="number" name="numStudents" required /><br><br>

    <button type="submit" name="action" value="Insert">Insert</button>
    <button type="submit" name="action" value="View">View</button>
    <button type="submit" name="action" value="Update">Update</button>
    <button type="submit" name="action" value="Delete">Delete</button>
</form>

</body>
</html>
