import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class FipeApiExample {
    public static void main(String[] args) throws Exception {
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        JsonArray marcasArray = JsonParser.parseString(response.body()).getAsJsonArray();

        for (int i = 0; i < 5; i++) {
            String nome = marcasArray.get(i).getAsJsonObject().get("nome").getAsString();
            String codigo = marcasArray.get(i).getAsJsonObject().get("codigo").getAsString();
            System.out.println("Marca: " + nome + " - Código: " + codigo);
        }
    }
}
