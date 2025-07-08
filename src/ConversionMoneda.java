import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversionMoneda {

    Gson GSON = new Gson();


    public Moneda convertirMoneda(String opcionConversion) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/0bfdeacf54f613e7fde0ef37/latest/"
                + opcionConversion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return GSON.fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
