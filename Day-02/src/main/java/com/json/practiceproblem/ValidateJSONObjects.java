package com.json.practiceproblem;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ValidateJSONObjects {




    public class ValidateJsonWithJackson {
        public static void main(String[] args) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Read and parse JSON file
                JsonNode jsonNode = objectMapper.readTree(new File("student.json"));

                // Check if required fields exist
                if (jsonNode.has("name") && jsonNode.has("email")) {
                    System.out.println("Valid JSON structure!");
                } else {
                    System.out.println("Invalid JSON: Missing required fields!");
                }
            } catch (IOException e) {
                System.out.println("Invalid JSON: " + e.getMessage());
            }
        }

    }
