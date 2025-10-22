package challenge.moedas;

import challenge.tratamentodejson.ConversaoResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conversor {
    private static final String API_URL = "https://api.fastforex.io/fetch-one";
    private static final String API_KEY = carregarChaveAPI();

    private static String carregarChaveAPI() {
        try {
            java.util.Properties props = new java.util.Properties();
            java.io.FileInputStream file = new java.io.FileInputStream("config.properties");
            props.load(file);
            return props.getProperty("API_KEY");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar API_KEY do arquivo config.properties");
        }
    }

    public static String converter(String from, String to) {
        try {
            String urlString = API_URL + "?from=" + from + "&to=" + to;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-API-Key", API_KEY);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                resposta.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            ConversaoResponse conversao = gson.fromJson(resposta.toString(), ConversaoResponse.class);

            double valorConvertido = conversao.result.get(to);

            return String.format("1 %s = %.4f %s", from, valorConvertido, to);

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}
