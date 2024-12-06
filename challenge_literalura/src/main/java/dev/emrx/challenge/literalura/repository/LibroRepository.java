package dev.emrx.challenge.literalura.repository;

import dev.emrx.challenge.literalura.model.entity.Idioma;
import dev.emrx.challenge.literalura.model.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * LibroRepository es una interfaz para gestionar las operaciones de base de datos en las entidades Libro.
 * Extiende JpaRepository para aprovechar los métodos de Spring Data JPA para las operaciones CRUD.
 *
 * @author M3LB1Z
 * @version 1.0
 * @since 2024.1.1
 */

public interface LibroRepository extends JpaRepository<Libro, Long> {

    /**
     * Este método recupera una lista de entidades Libro que están en un idioma específico.
     * Utiliza una consulta personalizada para filtrar los libros en función de su idioma.
     *
     * @param idioma El idioma de los libros a buscar.
     * @return Una lista de entidades Libro que están en el idioma especificado.
     */
    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> obtenerLibrosPorIdioma(Idioma idioma);

    /**
     * Este método busca un libro por su título.
     *
     * @param titulo El título del libro a buscar.
     * @return Un Optional que puede contener el Libro si se encuentra.
     */
    Optional<Libro> findByTitulo(String titulo);
}
