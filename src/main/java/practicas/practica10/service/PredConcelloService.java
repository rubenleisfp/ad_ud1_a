package practicas.practica10.service;

import com.google.gson.*;
import practicas.practica10.model.*;
import practicas.practica10.service.dto.TemperaturaMedia;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PredConcelloService {

    public void escribirTemperaturaMediaEnFichero(String inputFilePath, String outputfilePath) throws IOException {
        TemperaturaMedia temperaturaMedia = getTemperaturaMediaSemanal(inputFilePath);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tmax_promedio", temperaturaMedia.getTmax());
        jsonObject.addProperty("tmin_promedio", temperaturaMedia.getTmi());

        try (FileWriter fileWriter = new FileWriter(outputfilePath)) {
            fileWriter.write(new Gson().toJson(jsonObject));
            fileWriter.flush();
        }
    }

    public TemperaturaMedia getTemperaturaMediaSemanal(String filePath) throws IOException {
        PredConcello predConcello = getPredConcelloFromJsonFile(filePath);
        List<PredDiaConcello> listaPredDiaConcello = predConcello.getListaPredDiaConcello();

        if (listaPredDiaConcello == null || listaPredDiaConcello.isEmpty()) {
            throw new IllegalArgumentException("La lista de predicciones está vacía o es nula.");
        }

        double sumaTmax = 0;
        double sumaTmin = 0;
        int totalDias = listaPredDiaConcello.size();

        for (PredDiaConcello predDia : listaPredDiaConcello) {
            sumaTmax += predDia.gettMax();
            sumaTmin += predDia.gettMin();
        }

        return new TemperaturaMedia(sumaTmax / totalDias, sumaTmin / totalDias);
    }

    public PredConcello getPredConcelloFromJsonFile(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            JsonObject predConcelloJson = root.getAsJsonObject("predConcello");

            PredConcello predConcello = new PredConcello();
            predConcello.setIdConcello(predConcelloJson.get("idConcello").getAsInt());
            predConcello.setNome(predConcelloJson.get("nome").getAsString());

            JsonArray listaPredDiaConcelloJson = predConcelloJson.getAsJsonArray("listaPredDiaConcello");
            List<PredDiaConcello> listaPredDiaConcello = new ArrayList<>();

            for (JsonElement item : listaPredDiaConcelloJson) {
                JsonObject itemJson = item.getAsJsonObject();

                PredDiaConcello predDia = new PredDiaConcello();
                predDia.setDataPredicion(itemJson.get("dataPredicion").getAsString());
                predDia.setNivelAviso(itemJson.has("nivelAviso") ? itemJson.get("nivelAviso").getAsInt() : null);
                predDia.settMax(itemJson.get("tMax").getAsInt());
                predDia.settMin(itemJson.get("tMin").getAsInt());
                predDia.setTmaxFranxa(itemJson.has("tmaxFranxa") ? itemJson.get("tmaxFranxa").getAsInt() : null);
                predDia.setTminFranxa(itemJson.has("tminFranxa") ? itemJson.get("tminFranxa").getAsInt() : null);
                predDia.setUvMax(itemJson.get("uvMax").getAsInt());

                JsonObject ceoJson = itemJson.getAsJsonObject("ceo");
                Ceo ceo = new Ceo();
                ceo.setManha(ceoJson.get("manha").getAsInt());
                ceo.setNoite(ceoJson.get("noite").getAsInt());
                ceo.setTarde(ceoJson.get("tarde").getAsInt());
                predDia.setCeo(ceo);

                JsonObject pchoivaJson = itemJson.getAsJsonObject("pchoiva");
                PChoiva pchoiva = new PChoiva();
                pchoiva.setManha(pchoivaJson.get("manha").getAsInt());
                pchoiva.setNoite(pchoivaJson.get("noite").getAsInt());
                pchoiva.setTarde(pchoivaJson.get("tarde").getAsInt());
                predDia.setPchoiva(pchoiva);

                JsonObject ventoJson = itemJson.getAsJsonObject("vento");
                Vento vento = new Vento();
                vento.setManha(ventoJson.get("manha").getAsInt());
                vento.setNoite(ventoJson.get("noite").getAsInt());
                vento.setTarde(ventoJson.get("tarde").getAsInt());
                predDia.setVento(vento);

                listaPredDiaConcello.add(predDia);
            }

            predConcello.setListaPredDiaConcello(listaPredDiaConcello);

            return predConcello;
        }
    }
}
