package com.json.handsonproblem;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
public class ConvertJsontoXml {
    public static void main(String[] args) {
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
