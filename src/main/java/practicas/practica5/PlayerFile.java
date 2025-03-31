package practicas.practica5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PlayerFile {

	/*
	public List<Player> readCsv(File csvFile) {

		List<Player> players = new ArrayList<Player>();
		try (BufferedReader in = new BufferedReader(new FileReader(csvFile));) {

			players = in.lines().skip(1).map(line -> {
				return getPlayerFromLine(line);
			}).collect(Collectors.toList());

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Fichero no encontrado", e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return players;
	}

	public void toJsonFile(List<Player> players, File jsonFile) {
		Gson gson = new GsonBuilder()
				  .setPrettyPrinting()
				  .create();
		players.removeAll(Collections.singleton(null));
		try (FileWriter writer = new FileWriter(jsonFile)) {
			gson.toJson(players, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Player getPlayerFromLine(String line) {
		Player player = null;
		try {
			Pattern pattern = Pattern.compile(",");
			String[] x = pattern.split(line);
			// return new Player();
			int anho = Integer.valueOf(x[0]);
			String nombre = x[1];
			String equipo = x[2];
			Double salario = Double.valueOf(x[3]);
			player = new Player(anho, nombre, equipo, salario);
		} catch (Exception ex) {
			System.out.println("Error parseando la linea: " + line);
			System.out.println(ex);
		}
		return player;
	}
	*/

}
