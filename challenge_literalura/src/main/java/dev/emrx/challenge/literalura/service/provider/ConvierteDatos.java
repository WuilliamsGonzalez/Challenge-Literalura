package dev.emrx.challenge.literalura.service.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ConvierteDatos es una clase Singleton que implementa la interfaz IConvierteDatos.
 * Proporciona un método para convertir una cadena JSON en un objeto de una clase específica.
 * Utiliza ObjectMapper de la biblioteca Jackson para realizar la conversión.
 *
 * @author M3LB1Z
 * @version 1.0
 * @since 2024.1.1
 */
public class ConvierteDatos implements IConvierteDatos {

    private static ConvierteDatos instance;
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Constructor privado para evitar la creación de instancias directas de esta clase.
     */
    private ConvierteDatos() {}

    /**
     * Método para obtener la única instancia de esta clase.
     * Si la instancia no existe, se crea.
     *
     * @return La única instancia de ConvierteDatos.
     */
    public static synchronized ConvierteDatos getInstance() {
        if (instance == null) {
            instance = new ConvierteDatos();
        }
        return instance;
    }

    /**
     * Este método convierte una cadena JSON en un objeto de una clase específica.
     *
     * @param json La cadena JSON a convertir.
     * @param clase La clase del objeto en el que se convertirá la cadena JSON.
     * @return El objeto resultante de la conversión.
     * @throws RuntimeException si ocurre un error durante la conversión.
     */
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
