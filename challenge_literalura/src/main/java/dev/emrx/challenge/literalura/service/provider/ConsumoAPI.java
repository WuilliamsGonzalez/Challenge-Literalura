package dev.emrx.challenge.literalura.service.provider;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * ConsumoAPI es una clase Singleton que proporciona un método para obtener datos de una URL específica.
 * Utiliza HttpClient para enviar una solicitud HTTP y obtener la respuesta.
 *
 * @author M3LB1Z
 * @version 1.0
 * @since 2024.1.1
 */
public class ConsumoAPI {

    private static ConsumoAPI instance;

    /**
     * Constructor privado para evitar la creación de instancias directas de esta clase.
     */
    private ConsumoAPI() {}

    /**
     * Método para obtener la única instancia de esta clase.
     * Si la instancia no existe, se crea.
     *
     * @return La única instancia de ConsumoAPI.
     */
    public static synchronized ConsumoAPI getInstance() {
        if (instance == null) {
            instance = new ConsumoAPI();
        }
        return instance;
    }

    /**
     * Este método envía una solicitud HTTP a la URL proporcionada y devuelve la respuesta como una cadena.
     *
     * @param url La URL a la que se enviará la solicitud HTTP.
     * @return La respuesta de la solicitud HTTP como una cadena.
     * @throws RuntimeException si ocurre un error al enviar la solicitud o recibir la respuesta.
     */
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }

}
