package com.json.practiceproblem;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class ParsejsonFilter {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootArray = objectMapper.readTree(new File("students.json"));

            // List to store filtered records
            List<JsonNode> filteredRecords = new ArrayList<>();

            // Iterate over JSON array and filter records
            for (JsonNode node : rootArray) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }

            // Convert filtered records back to JSON string
            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredRecords);

            // Print filtered JSON output
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
