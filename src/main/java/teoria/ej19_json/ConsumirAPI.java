package teoria.ej19_json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class ConsumirAPI {

	public static void main(String[] args) {
		String apiUrl = "https://jsonplaceholder.typicode.com/users";

		List<User> users = getUsers(apiUrl);

		// Mostrar el resultado
		for (User user : users) {
			System.out.println("ID: " + user.getId());
			System.out.println("Nombre: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println("--------");
		}

	}

	private static List<User> getUsers(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String inputLine;

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			// Deserializar el objeto JSON utilizando Gson
			Gson gson = new Gson();
			User[] users = gson.fromJson(response.toString(), User[].class);
			List<User> userAsList = Arrays.asList(users);
			return userAsList;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}

class User {
	private int id;
	private String name;
	private String email;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}