package com.json.handsonproblem;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Filerjsondata {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootArray = objectMapper.readTree(new File("users.json"));

            // List to store filtered records
            List<JsonNode> filteredUsers = new ArrayList<>();

            // Iterate over JSON array and filter users
            for (JsonNode user : rootArray) {
                if (user.has("age") && user.get("age").asInt() > 25) {
                    filteredUsers.add(user);
                }
            }

            // Convert filtered records back to JSON string
            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers);

            // Print filtered JSON output
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
