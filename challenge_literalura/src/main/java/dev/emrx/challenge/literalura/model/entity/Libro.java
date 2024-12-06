package dev.emrx.challenge.literalura.model.entity;

import dev.emrx.challenge.literalura.model.DatosLibro;
import jakarta.persistence.*;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String temas;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Integer contadorDeDescargas;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libros_autores",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores;

    public Libro() {
    }

    public Libro(DatosLibro libro) {
        this.titulo = libro.titulo();
        this.temas = libro.temas().stream()
                .collect(Collectors.joining(";"));
        this.idioma = Idioma.fromString(libro.idiomas().get(0));
        this.contadorDeDescargas = libro.contadorDeDescargas();
        this.autores = libro.autores().stream()
                .map(da -> new Autor(da))
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Integer getContadorDeDescargas() {
        return contadorDeDescargas;
    }

    public void setContadorDeDescargas(Integer contadorDeDescargas) {
        this.contadorDeDescargas = contadorDeDescargas;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        String listaAutores = autores.stream()
                .map(Autor::getNombre)
                .collect(Collectors.joining(", "));

        return """
                --------- LIBRO ---------
                Titulo: %s
                Autor: %s
                Idioma: %s
                Numero de descargas: %d
                -------------------------
                """.formatted(
                    titulo,
                    listaAutores,
                    idioma,
                    contadorDeDescargas);
    }
}
