package dev.emrx.challenge.literalura.repository;

import dev.emrx.challenge.literalura.model.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * AutorRepository es una interfaz para gestionar las operaciones de base de datos en las entidades Autor.
 * Extiende JpaRepository para aprovechar los métodos de Spring Data JPA para las operaciones CRUD.
 *
 * @author M3LB1Z
 * @version 1.0
 * @since 2024.1.1
 */

public interface AutorRepository extends JpaRepository<Autor, Long> {

    /**
     * Este método recupera una lista de entidades Autor que estaban vivas en un año específico.
     * Utiliza una consulta personalizada para filtrar los autores en función de sus años de nacimiento y fallecimiento.
     *
     * @param anio El año para verificar los autores vivos.
     * @return Una lista de entidades Autor que estaban vivas en el año especificado.
     */
    @Query("SELECT a FROM Autor a WHERE a.anhioDeNacimiento <= :anio AND a.anhioDeFallecimiento > :anio")
    List<Autor> obtenerAutoresVivosPorAnio(int anio);
}
