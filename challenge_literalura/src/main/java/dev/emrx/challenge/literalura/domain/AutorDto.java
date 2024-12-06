package dev.emrx.challenge.literalura.domain;

import dev.emrx.challenge.literalura.model.entity.Autor;
import dev.emrx.challenge.literalura.model.entity.Libro;

import java.util.List;
import java.util.stream.Collectors;

public record AutorDto(
        String nombre,
        Integer anhioDeNacimiento,
        Integer anhioDeFallecimiento,
        String librosEscritos
) {
    public AutorDto(Autor autor) {
        this(
                autor.getNombre(),
                autor.getAnhioDeNacimiento(),
                autor.getAnhioDeFallecimiento(),
                autor.getLibros()
                        .stream()
                        .map(Libro::getTitulo)
                        .collect(Collectors.joining(", "))
        );
    }

    @Override
    public String toString() {
        return """
                Autor: %s
                Fecha de nacimiento: %d
                Fecha de fallecimiento: %d
                Libros: [%s]
                """.formatted(nombre, anhioDeNacimiento, anhioDeFallecimiento, librosEscritos);
    }
}
