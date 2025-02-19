package com.json.practiceproblem;

import org.json.JSONObject;

public class MergeTwojsonFiles {
    public static void main(String[] args) {
        // First JSON Object
        JSONObject json1 = new JSONObject();
        json1.put("name", "Alice");
        json1.put("age", 25);

        // Second JSON Object
        JSONObject json2 = new JSONObject();
        json2.put("email", "alice@example.com");
        json2.put("city", "New York");

        // Merge JSON Objects
        JSONObject mergedJson = new JSONObject(json1, JSONObject.getNames(json1));
        for (String key : JSONObject.getNames(json2)) {
            mergedJson.put(key, json2.get(key));
        }

        // Print Merged JSON
        System.out.println(mergedJson.toString(4)); // Pretty print
    }
}
