package com.json.practiceproblem;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadAjsonFile {
    public static void main(String[] args) {
        try {
            // Read JSON file into a String
            String content = new String(Files.readAllBytes(Paths.get("student.json")));

            // Convert String to JSONObject
            JSONObject jsonObject = new JSONObject(content);

            // Extract specific fields
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            // Print extracted fields
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
