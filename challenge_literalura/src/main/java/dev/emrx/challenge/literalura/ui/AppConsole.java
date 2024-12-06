package dev.emrx.challenge.literalura.ui;

import dev.emrx.challenge.literalura.domain.AutorDto;
import dev.emrx.challenge.literalura.domain.LibroDto;
import dev.emrx.challenge.literalura.model.Datos;
import dev.emrx.challenge.literalura.model.DatosLibro;
import dev.emrx.challenge.literalura.model.entity.Autor;
import dev.emrx.challenge.literalura.model.entity.Idioma;
import dev.emrx.challenge.literalura.model.entity.Libro;
import dev.emrx.challenge.literalura.service.AutorService;
import dev.emrx.challenge.literalura.service.provider.ConsumoAPI;
import dev.emrx.challenge.literalura.service.provider.ConvierteDatos;
import dev.emrx.challenge.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class AppConsole {

    private static final String URL_BASE = "https://gutendex.com/books/";

    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = ConsumoAPI.getInstance();
    private ConvierteDatos conversor = ConvierteDatos.getInstance();

    public void ejecutarOperaciones() {
        int operacion = -1;
        while (operacion != 0) {
            mostrarMenu();
            try {
                operacion = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opciones válidas: 0, 1, 2, 3, 4, 5");
                continue;
            } finally {
                teclado.nextLine();
            }
            switch (operacion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosPorAnio();
                    break;
                case 5:
                    mostrarIdiomas();
                    listarLibrosPorIdioma();
                    break;
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("""
                Menu de opciones:
                1- Buscar libro por titulo
                2- Listar libros registrados
                3- Listar autores registrados
                4- Listar autores vivos en un determinado año
                5- Listar libros por idioma
                0- Salir
                Elija la opción a través de su número:                
                """);
    }

    public void mostrarIdiomas() {
        for (Idioma idioma : Idioma.values()) {
            System.out.println(idioma.mostrar());
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar");
        String titulo = teclado.nextLine();

        String json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + titulo.replace(" ", "+"));

        DatosLibro libroBuscado = conversor.obtenerDatos(json, Datos.class).libros().get(0);
        LibroDto libroNuevo = libroService.guardarLibro(libroBuscado);
        System.out.println(libroNuevo);
    }

    private void listarLibrosRegistrados() {
        List<LibroDto> librosRegistrados = libroService.obtenerLibros();
        librosRegistrados.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<AutorDto> autoresRegistrados = autorService.obtenerAutores();
        autoresRegistrados.forEach(System.out::println);
    }

    private void listarAutoresVivosPorAnio() {
        System.out.println("Ingrese el año de los autor(es) vivos que desea buscar: ");
        int anio = 0;
        try {
            anio = teclado.nextInt();
            List<AutorDto> autoresVivos = autorService.obtenerAutoresVivosPorAnio(anio);
            autoresVivos.forEach(System.out::println);
        } catch (InputMismatchException e) {
            System.out.println("Ingreso un año inválido. No se pudo realizar la búsqueda.");
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Escriba el idioma deseado: ");
        String abreviatura = teclado.nextLine();
        Idioma idioma = Idioma.fromString(abreviatura);

        List<LibroDto> librosPorIdioma = libroService.obtenerLibrosPorIdioma(idioma);
        librosPorIdioma.forEach(System.out::println);
    }

}
