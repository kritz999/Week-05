package com.json.handsonproblem;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
public class MergeTwoJsonFiles {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read both JSON files
            JsonNode json1 = objectMapper.readTree(new File("file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("file2.json"));

            // Merge JSON objects
            JsonNode mergedJson = json1.deepMerge(json2);

            // Convert merged JSON to string
            String mergedJsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson);

            // Print merged JSON
            System.out.println(mergedJsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
