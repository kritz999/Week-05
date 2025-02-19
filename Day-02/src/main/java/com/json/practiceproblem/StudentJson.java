package com.json.practiceproblem;
import org.json.JSONArray;
import org.json.JSONObject;


public class StudentJson {
    public static void main(String[] args)  {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Alice");
        jsonObject.put("age", 25);

        JSONArray subjectArray = new JSONArray();
        subjectArray.put("mathematics");
        subjectArray.put("Physics");
        subjectArray.put("Computer Science");

        // Adding subjects array to JSON object
        jsonObject.put("subjects", subjectArray);

        // Print JSON output
        System.out.println(jsonObject.toString(4));


    }

}
