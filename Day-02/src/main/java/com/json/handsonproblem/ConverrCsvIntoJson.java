package com.json.handsonproblem;
import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
public class ConverrCsvIntoJson {
    public static void main(String[] args) {
        // JSON String
        String json = "{ \"name\": \"Alice\", \"age\": 25, \"email\": \"alice@example.com\" }";

        // Convert JSON to XML
        JSONObject jsonObject = new JSONObject(json);
        String xml = XML.toString(jsonObject, "User");

        // Print XML
        System.out.println(xml);
    }
    try {
        // JSON String
        String json = "{ \"name\": \"Alice\", \"age\": 25, \"email\": \"alice@example.com\" }";

        // Convert JSON to XML
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // Print XML
        System.out.println(xml);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
