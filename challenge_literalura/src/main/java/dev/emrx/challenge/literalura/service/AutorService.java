package dev.emrx.challenge.literalura.service;

import dev.emrx.challenge.literalura.domain.AutorDto;
import dev.emrx.challenge.literalura.domain.LibroDto;
import dev.emrx.challenge.literalura.model.entity.Autor;
import dev.emrx.challenge.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AutorService es una clase que proporciona servicios relacionados con la entidad Autor.
 * Utiliza AutorRepository para realizar operaciones de base de datos.
 *
 * @author M3LB1Z
 * @version 1.0
 * @since 2024.1.1
 */
@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    /**
     * Este método recupera una lista de todas las entidades Autor.
     *
     * @return Una lista de entidades Autor.
     */
    public List<AutorDto> obtenerAutores() {
        return repository.findAll().stream()
                .map(autor -> new AutorDto(autor))
                .toList();
    }

    /**
     * Este método recupera una lista de entidades Autor que estaban vivas en un año específico.
     *
     * @param anio El año para verificar los autores vivos.
     * @return Una lista de entidades Autor que estaban vivas en el año especificado.
     */
    public List<AutorDto> obtenerAutoresVivosPorAnio(int anio) {
        return repository.obtenerAutoresVivosPorAnio(anio).stream()
                .map(autor -> new AutorDto(autor))
                .toList();
    }
}
