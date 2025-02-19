package com.json.handsonproblem;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
public class ValidateAnEmail {
    public static void main(String[] args) {
        try {
            // Load JSON Schema
            FileInputStream schemaStream = new FileInputStream(new File("schema.json"));
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(rawSchema);

            // JSON object to validate
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Alice");
            jsonObject.put("email", "alice@example.com");  // ✅ Valid email

            // Validate JSON against schema
            schema.validate(jsonObject);

            System.out.println("✅ JSON is valid!");

        } catch (Exception e) {
            System.out.println("❌ JSON validation failed: " + e.getMessage());
        }
    }
}
