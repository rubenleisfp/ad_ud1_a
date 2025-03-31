package teoria.ej19_json.mkyong;

import com.google.gson.Gson;


public class GsonParseJsonStringExample {

    public static void main(String[] args) {

        String json = "{\"name\": \"mkyong\", \"age\": 20}";

        Gson gson = new Gson();

        Person person = gson.fromJson(json, Person.class);

        System.out.println(person);

    }
}