package com.json.practiceproblem;

import org.json.JSONObject;

class Car{
    private String brand;
    private String model;
    private int year;

    public Car(String brand ,String model ,int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    //getter
    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public int getValue(){
        return year;
    }

}

public class ConvertObjectToJSON {
    public static void main(String[] args) {
        Car car = new Car("toyota","corolla",2022);

        //converting car object to JSON
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brand",car.getValue());
        jsonObject.put("model",car.getModel());
      //  jsonObject.put("year", car.getYear());

        System.out.println(jsonObject.toString(4));
    }
}
