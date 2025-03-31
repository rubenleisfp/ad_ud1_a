package practicas.futbol.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import practicas.futbol.model.Equipo;
import practicas.futbol.model.Titulo;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EquipoDao {

    public List<Equipo> leerEquipos(String sourcePath) throws Exception {
        List<Equipo> equipos = new ArrayList<>();

        try (FileReader reader = new FileReader(sourcePath)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (var element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String nombre = jsonObject.get("equipo").getAsString();

                JsonObject titulosObject = jsonObject.getAsJsonObject("titulos");
                List<Titulo> titulos = new ArrayList<>();

                for (String key : titulosObject.keySet()) {
                    int cantidad = titulosObject.get(key).getAsInt();
                    titulos.add(new Titulo(key, cantidad));
                }

                equipos.add(new Equipo(nombre, titulos));
            }
        }

        return equipos;
    }

    public void escribirCsv(String targetPath, List<Equipo> equipos) throws Exception {
        try (FileWriter writer = new FileWriter(targetPath)) {
            writer.write("equipo;total_titulos\n");
            for (Equipo equipo : equipos) {
                writer.write(equipo.getNombre() + ";" + equipo.getTotalTitulos() + "\n");
            }
        }
    }
}
