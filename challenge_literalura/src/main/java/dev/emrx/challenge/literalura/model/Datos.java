package dev.emrx.challenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        @JsonAlias("count") Integer cantidad,
        @JsonAlias("results") List<DatosLibro> libros,
        @JsonAlias("next") String siguiente
) {}
