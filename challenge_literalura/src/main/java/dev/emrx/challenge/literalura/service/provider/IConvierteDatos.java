package dev.emrx.challenge.literalura.service.provider;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
