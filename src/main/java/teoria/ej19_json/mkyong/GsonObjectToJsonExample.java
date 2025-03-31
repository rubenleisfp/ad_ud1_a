package teoria.ej19_json.mkyong;

import com.google.gson.Gson;

public class GsonObjectToJsonExample {

    public static void main(String[] args) {

        Person person = new Person("ponce", 20);

        Gson gson = new Gson();

        // Java object to json
        String json = gson.toJson(person);

        //{"name":"mkyong","age":42}
        System.out.println(json);


    }
}