package com.json.handsonproblem;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int age;
    private String email;

    // Constructor
    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters (required for serialization)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

public class ConvertlistintoJSONArray {
    public static void main(String[] args) {
        try {
            // Create a list of Student objects
            List<Student> students = new ArrayList<>();
            students.add(new Student("Alice", 24, "alice@example.com"));
            students.add(new Student("Bob", 27, "bob@example.com"));
            students.add(new Student("Charlie", 22, "charlie@example.com"));

            // Convert list to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);

            // Print JSON array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
