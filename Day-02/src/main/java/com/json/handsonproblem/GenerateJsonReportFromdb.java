package com.json.handsonproblem;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.*;
import java.io.File;
public class GenerateJsonReportFromdb {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/CompanyDB";
        String user = "root";  // Replace with your MySQL username
        String password = "password";  // Replace with your MySQL password

        String query = "SELECT * FROM employees";

        List<Map<String, Object>> employeesList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Process ResultSet
            while (rs.next()) {
                Map<String, Object> employee = new HashMap<>();
                employee.put("id", rs.getInt("id"));
                employee.put("name", rs.getString("name"));
                employee.put("age", rs.getInt("age"));
                employee.put("department", rs.getString("department"));
                employee.put("salary", rs.getDouble("salary"));

                employeesList.add(employee);
            }

            // Convert List to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeesList);

            // Save JSON to File
            File file = new File("employee_report.json");
            objectMapper.writeValue(file, employeesList);

            // Print JSON Output
            System.out.println("✅ JSON Report Generated Successfully!");
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
